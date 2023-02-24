import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Bus[] buses = new Bus[n];
        for(int i = 0 ; i < n ;i++){
            int min = i*t;
            int hour = 9+min/60;
            min %= 60;
            buses[i] = new Bus(hour, min);
        }
        int idx = 0;
        List<Time> list = new ArrayList<>();
        for(String str : timetable){
            String[] strArr = str.split(":");
            int hour = Integer.parseInt(strArr[0]);
            int min = Integer.parseInt(strArr[1]);
            list.add(new Time(hour, min));
        }
        list.sort((o1,o2)->{
           if(o1.hour==o2.hour)
               return o1.min-o2.min;
            return o1.hour-o2.hour;
        });
        for(Time time : list){
            int hour = time.hour;
            int min = time.min;
            while(idx<n && (!buses[idx].isPossible(hour,min) || buses[idx].rider>=m)){
                idx++;
            }
            if(idx>=n)
                break;
            buses[idx].add(hour,min);
        }
        for(Bus bus : buses){
            System.out.println(bus.hour +":"+bus.min+"   "+bus.rider);
        }
        
        Bus lastBus = buses[n-1];
        
        int lastHour = lastBus.lastHour;
        
        
        int lastMin = lastBus.lastMin;
        System.out.println("hour : "+lastHour+"min : "+lastMin+"rider :"+lastBus.rider);
        
        if(lastBus.rider<m)
            return timeToString(lastBus.hour, lastBus.min);
        if(lastBus.rider==0)
            return timeToString(lastBus.hour, lastBus.min);
        if(lastMin == 0){
            lastMin = 59;
            lastHour--;
        } else{
            lastMin--;
        }
        return timeToString(lastHour,lastMin);
        
        
    }
    
    public String timeToString(int hour, int min){
        String result = "";
        if(hour < 10)
            result += "0";
        result+=hour+":";
        if(min < 10)
            result += "0";
        result+=min;
        return result;
    }
    
    
}

class Time{
    int hour;
    int min;
    public Time(int hour, int min){
        this.hour = hour;
        this.min = min;
    }
}

class Bus{
    int hour;
    int min;
    int rider;
    int lastHour;
    int lastMin;
    public Bus(int hour, int min){
        this.hour = hour;
        this.min = min;
    }
    public void add(int hour, int min){
        rider++;
        lastHour = hour;
        lastMin = min;
    }
    public boolean isPossible(int hour, int min){
        if(this.hour == hour){
            return this.min>=min;
        }
        return this.hour>=hour;
    }
}