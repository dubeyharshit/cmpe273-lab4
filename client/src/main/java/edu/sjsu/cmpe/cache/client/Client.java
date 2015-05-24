package edu.sjsu.cmpe.cache.client;

import com.mashape.unirest.http.Unirest;

public class Client {

    public static void main(String[] args) throws Exception {
        CacheServiceInterface cache = new DistributedCacheService( "http://localhost",
                new Integer(3000),
                new Integer(3));

        System.out.println("STEP 1: Putting 1 => 'a' on all the servers");
        cache.put(1, "a");
        System.out.println("Sleep for 30 Seconds");
        Thread.sleep(30000);

        System.out.println("STEP 2: Putting 1 => 'b' on all the servers");
        cache.put(1, "b");
        System.out.println("Sleep for 30 Seconds");
        Thread.sleep(30000);

        System.out.println("STEP 3: GET 1 from all the servers");
        String value = cache.get(1);
        System.out.println("get(1) => " + value);
        System.out.println("Exit");


        Unirest.shutdown();
    }

}
