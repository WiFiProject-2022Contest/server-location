package com.wifilocation.demo.controller;

import com.wifilocation.demo.RSSIMapper;
import com.wifilocation.demo.model.Estimate;
import com.wifilocation.demo.model.RSSID;
import com.wifilocation.demo.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class RSSIController {

    @Autowired
    private RSSIMapper rssiMapper;

    @GetMapping("/rssi/all")
    public List<RSSID> getAll() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET All Data");
        return rssiMapper.findAll();
    }

    @GetMapping("/rssi/find")
    public List<RSSID> getByParam(@RequestParam(name = "building", required = false) String building,
                                  @RequestParam(name = "SSID", required = false) String SSID) {
        LocalDateTime now = LocalDateTime.now();
        if (building == null && SSID == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tRequire at least one parameter;building or SSID");
            return null;
        } else if (building == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data(" + SSID + ")");
            return rssiMapper.findBySsid(SSID);
        } else if (SSID == null) {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data(" + building + ")");
            return rssiMapper.findByBuilding(building);
        } else {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data(" + SSID + " and " + building + ")");
            return rssiMapper.findByTwo(building, SSID);
        }
    }

    @GetMapping("/rssi")
    public List<RSSID> getPos(@RequestParam(name = "pos_x", defaultValue = "-1") float pos_x,
                              @RequestParam(name = "pos_y", defaultValue = "-1") float pos_y,
                              @RequestParam(name = "building", required = false) String building,
                              @RequestParam(name = "SSID", required = false) String SSID,
                              @RequestParam(name = "from", defaultValue = "20020202") String from,
                              @RequestParam(name = "to", defaultValue = "20300303") String to) {
        long tmp = System.currentTimeMillis();
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        try {
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET data for (" + pos_x + ", " + pos_y + ")\n\tFrom " +
                from + " To " + to + " At " + building + ", " + SSID +
                "\n\t\t" + (System.currentTimeMillis() - tmp));
        return rssiMapper.findDynamic((int) pos_x, (int) pos_y, building, SSID, start, end);
    }

    @GetMapping("/rssi/estimate")
    public List<RSSID> getSpecific(@RequestParam(name = "building", required = false) String building,
                                   @RequestParam(name = "SSID", required = false) String SSID,
                                   @RequestParam(name = "from", defaultValue = "20020202") String from,
                                   @RequestParam(name = "to", defaultValue = "20300303") String to) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        try {
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Data\n\tFrom " +
                from + " To " + to + " / " + building + ", " + SSID);
        return rssiMapper.findByDateAndBuild(building, SSID, start, end);
    }

    @PostMapping("/rssi")
    public Result postMethod(@RequestBody List<RSSID> rssids) {
        long tmp = System.currentTimeMillis();
        if (rssids.size() != 0) {
            rssiMapper.insert(rssids);
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully POST " + rssids.size() + " data\n\t\t"
                + (System.currentTimeMillis() - tmp));
        Result result = new Result(true, rssids.size());
        return result;
    }

    //    String building, String SSID, String uuid, Date from, Date to
    @GetMapping("/rssi/delete")
    public Result delete(@RequestParam(name = "auth", required = false) String key,
                         @RequestParam(name = "building", required = false) String building,
                         @RequestParam(name = "SSID", required = false) String SSID,
                         @RequestParam(name = "uuid", required = false) String uuid,
                         @RequestParam(name = "from", defaultValue = "20020202") String from,
                         @RequestParam(name = "to", defaultValue = "20300303") String to) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        Result result = new Result(true, 0);
        try {
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        if (Objects.equals(key, "wifilocation")) {
            int num = rssiMapper.deleteDynamic(building, SSID, uuid, start, end);
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tDelete for " +
                    building + ", " + SSID + ", " + uuid + " From " + from + " To " + to);
            result.setSuccess(true);
            result.setCount(num);
        } else {
            System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tWrong Auth Key; '" + key + "' is not allowed.");
            result.setSuccess(false);
            result.setCount(-1);
        }
        return result;
    }


    @GetMapping("/fingerprint")
    public List<Estimate> getEstimate(@RequestParam(name = "from", defaultValue = "20020202") String from,
                                      @RequestParam(name = "to", defaultValue = "20300303") String to) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        Date start = null, end = null;
        try {
            start = dateParser.parse(from);
            end = dateParser.parse(to);
            Calendar cal = Calendar.getInstance();
            cal.setTime(end);
            cal.add(Calendar.DATE, 1);
            end = new Date(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully GET Estimated Data\n\tFrom " +
                from + " To " + to);
        return rssiMapper.findEstimateByDate(start, end);
    }

    @PostMapping("/fingerprint")
    public Result insertEstimate(@RequestBody List<Estimate> est) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = new Date();
        String uuid = null;
        String date = dateFormat.format(today);
        int size = 0;
        if (est.size() != 0) {
            rssiMapper.insertEstimate(est);
            uuid = est.get(0).getUuid();
            if(est.get(0).getDate() != null) {
                date = dateFormat.format(est.get(0).getDate());
            }
            size = rssiMapper.findEstimateByUuidAndDate(uuid, date).size();
        }
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "\t\tSuccessfully POST " + est.size() + " Estimated data");
        Result result = new Result(true, size);
        return result;
    }

    @GetMapping("/test")
    public int test(@RequestParam(name = "uuid")String uuid, @RequestParam(name = "date") String date){
        return rssiMapper.findEstimateByUuidAndDate(uuid, date).size();
    }
}
