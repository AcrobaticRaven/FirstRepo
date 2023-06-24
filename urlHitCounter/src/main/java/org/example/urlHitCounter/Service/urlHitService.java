package org.example.urlHitCounter.Service;

import org.springframework.stereotype.Service;
@Service
public class urlHitService {
    public Integer hitCount = 0;
    public Integer userHitcount = 0;

    public Integer getcounter(){
        hitCount+=1;
        return hitCount;
    }
    public String getusercounts(String userName){
        userHitcount++;
        return "username : " + userName + ", " +
                "count : " + userHitcount;
    }
}
