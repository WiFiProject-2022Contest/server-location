package com.wifilocation.demo;

import com.wifilocation.demo.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class RSSIController {

    @Autowired
    private RSSIMapper rssiMapper;

    @GetMapping("/rssi/all")
    public List<RSSID> getAll(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET All Data");
        return rssiMapper.findAll();
    }

    @GetMapping("/rssi/find")
    public List<RSSID> getByParam(@RequestParam(name = "building", required = false) String building,
                                  @RequestParam(name = "SSID", required = false) String SSID){
        LocalDateTime now = LocalDateTime.now();
        if(building == null && SSID == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tRequire at least one parameter;building or SSID");
            return null;
        }
        else if(building == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data("+SSID+")");
            return rssiMapper.findBySsid(SSID);
        }
        else if(SSID == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data("+building+")");
            return rssiMapper.findByBuilding(building);
        }
        else {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data("+SSID+" and "+building+")");
            return rssiMapper.findByTwo(building, SSID);
        }
    }

    @GetMapping("/rssi")
    public List<RSSID> getPos(@RequestParam(name = "pos_x", defaultValue = "-1") float pos_x,
                              @RequestParam(name = "pos_y", defaultValue = "-1") float pos_y,
                              @RequestParam(name = "from", defaultValue = "20020202") String from,
                              @RequestParam(name = "to", defaultValue = "20300303") String to){
        LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        try{
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch(ParseException e){
            e.printStackTrace();
        }
        if(pos_x == -1 && pos_y == -1){
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET All Data\n\tFrom "+
                    from+" To "+to);
            return rssiMapper.findAllByDate(start, end);
        }
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET data for (" + pos_x + ", " + pos_y + ")\n\tFrom "+
                from+" To "+to);
        return rssiMapper.findByDateAndPos((int)pos_x, (int)pos_y, start, end);
    }

    @GetMapping("/rssi/estimate")
    public List<RSSID> getSpecific(@RequestParam(name = "building") String building,
                                   @RequestParam(name = "SSID") String SSID,
                                   @RequestParam(name = "from", defaultValue = "20020202") String from,
                                   @RequestParam(name = "to", defaultValue = "20300303") String to){
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        try{
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch(ParseException e){
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data\n\tFrom "+
                from+" To "+to+" / "+building + ", " + SSID);
        return rssiMapper.findByDateAndBuild(building, SSID, start, end);
    }

    @PostMapping("/rssi")
    public Result postMethod(@RequestParam(name = "pos_x") float pos_x,
                             @RequestParam(name = "pos_y") float pos_y,
                             @RequestBody List<RSSID> rssids){
        for(int i=0; i<rssids.size(); i++){
            rssids.get(i).setPos_x(pos_x);
            rssids.get(i).setPos_y(pos_y);
            rssiMapper.insert(rssids.get(i));
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully POST " + rssids.size() + " data");

        Result result = new Result(true);
        return result;
    }

    @GetMapping("/rssi/delete")
    public Result delete(@RequestParam(name = "auth", required = false) String key){
        Result result = new Result(true);
        LocalDateTime now = LocalDateTime.now();
        if(Objects.equals(key, "wifilocation")){
            rssiMapper.deleteAll();
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully Delete Whole Data");
            rssiMapper.initiate();
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully Initiate Auto Increment");
        }
        else{
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tWrong Auth Key; '"+key+"' is not allowed.");
            result.setSuccess(false);
        }
        return result;
    }

    @PostMapping("/fingerprint")
    public Result insertEstimate(@RequestBody RSSID rssid){
        rssiMapper.insertEstimate(rssid);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully POST Estimated Pos (" + rssid.getPos_x() + "," + rssid.getPos_y() + ")");

        Result result = new Result(true);
        return result;
    }
}
