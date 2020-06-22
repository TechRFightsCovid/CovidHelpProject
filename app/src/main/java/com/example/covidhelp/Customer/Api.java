package com.example.covidhelp.Customer;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
    //this is the URL of the paytm folder that we added in the server
    //make sure you are using your ip else it will not work
    String BASE_URL = "http://127.0.0.1/paytm/";

    @Multipart
    @POST("paytmallinone/init_Transaction.php")
    Call<Api> generateTokenCall(
            @Part("code") String language,
            @Part("MID") String mid,
            @Part("ORDER_ID") String order_id,
            @Part("AMOUNT") String amount
    );


}
