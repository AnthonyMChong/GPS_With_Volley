package com.google.android.gms.location.sample.locationupdates;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by anmchong on 4/21/2017.
 */

public class MySingleton {
    private static MySingleton myInstance;
    private RequestQueue requestQueue;
    private  static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }


    public  RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if(myInstance == null)
        {
            myInstance = new MySingleton(context);
        }
        return myInstance;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
