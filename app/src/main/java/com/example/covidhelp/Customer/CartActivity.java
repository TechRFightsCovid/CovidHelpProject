package com.example.covidhelp.Customer;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.covidhelp.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.covidhelp.DataModels.Items;
import com.example.covidhelp.R;
//import com.example.covidhelp.Utils.itemsAdapter;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
//import com.paytm.pgsdk.TransactionManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import okhttp3.RequestBody;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private ProgressBar progressBar;
    private EditText txnAmount;
    private String midString = "Your production mode MID here", txnAmountString = "", orderIdString = "", txnTokenString = "";
    private Button btnPayNow;
    private Integer ActivityRequestCode = 2;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            btnPayNow = (Button) findViewById(R.id.txnProcessBtn);
            txnAmount = (EditText) findViewById(R.id.txnAmountId);
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
            String date = df.format(c.getTime());
            Random rand = new Random();
            int min = 1000, max = 9999;
// nextInt as provided by Random is exclusive of the top value so you need to add 1
            int randomNum = rand.nextInt((max - min) + 1) + min;
            orderIdString = date + String.valueOf(randomNum);
            btnPayNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txnAmountString = txnAmount.getText().toString();
                    String errors = "";
                    if (orderIdString.equalsIgnoreCase("")) {
                        errors = "Enter valid Order ID here\n";
                        Toast.makeText(CartActivity.this, errors, Toast.LENGTH_SHORT).show();
                    } else if (txnAmountString.equalsIgnoreCase("")) {
                        errors = "Enter valid Amount here\n";
                        Toast.makeText(CartActivity.this, errors, Toast.LENGTH_SHORT).show();

                    } else {
                       // getToken();
                    }
                }
            });
        }
     /*   private void getToken () {
            Log.e(TAG, " get token start");
            progressBar.setVisibility(View.VISIBLE);
           Api api = new Api() {
                @Override
                public Call<Api> generateTokenCall(String language, String mid, String order_id, String amount) {
                    return null;
                }
            };*/
           /* Call<Api> call = api.generateTokenCall("12345", midString, orderIdString, txnAmountString);
            call.enqueue(new Callback<Api>() {
                @Override
                public void onResponse(Call<Api> call, Response<Api> response) {
                    Log.e(TAG, " respo " + response.isSuccessful());
                    progressBar.setVisibility(View.GONE);
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            if (response.body().getBody().getTxnToken() != "") {
                                Log.e(TAG, " transaction token : " + response.body().getBody().getTxnToken());
                                startPaytmPayment(response.body().getBody().getTxnToken());
                            } else {
                                Log.e(TAG, " Token status false");
                            }
                        }
                    } catch (Exception e) {

                        Log.e(TAG, " error in Token Res " + e.toString());
                    }
                }

                @Override
                public void onFailure(Call<Api> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Log.e(TAG, " response error " + t.toString());
                }
            });
        }*/
       /* public void startPaytmPayment (String token){
            txnTokenString = token;
            // for test mode use it
            // String host = "https://securegw-stage.paytm.in/";
            // for production mode use it
            String host = "https://securegw.paytm.in/";
            String orderDetails = "MID: " + midString + ", OrderId: " + orderIdString + ", TxnToken: " + txnTokenString
                    + ", Amount: " + txnAmountString;
            //Log.e(TAG, "order details "+ orderDetails);
            String callBackUrl = host + "theia/paytmCallback?ORDER_ID=" + orderIdString;
            Log.e(TAG, " callback URL " + callBackUrl);
            PaytmOrder paytmOrder = new PaytmOrder(orderIdString, midString, txnTokenString, txnAmountString, callBackUrl);
            TransactionManager transactionManager = new TransactionManager(paytmOrder, new PaytmPaymentTransactionCallback() {
                @Override
                public void onTransactionResponse(Bundle bundle) {
                    Log.e(TAG, "Response (onTransactionResponse) : " + bundle.toString());
                }

                @Override
                public void networkNotAvailable() {
                    Log.e(TAG, "network not available ");
                }

                @Override
                public void onErrorProceed(String s) {
                    Log.e(TAG, " onErrorProcess " + s.toString());
                }

                @Override
                public void clientAuthenticationFailed(String s) {
                    Log.e(TAG, "Clientauth " + s);
                }

                @Override
                public void someUIErrorOccurred(String s) {
                    Log.e(TAG, " UI error " + s);
                }

                @Override
                public void onErrorLoadingWebPage(int i, String s, String s1) {
                    Log.e(TAG, " error loading web " + s + "--" + s1);
                }

                @Override
                public void onBackPressedCancelTransaction() {
                    Log.e(TAG, "backPress ");
                }

                @Override
                public void onTransactionCancel(String s, Bundle bundle) {
                    Log.e(TAG, " transaction cancel " + s);
                }
            });
            transactionManager.setShowPaymentUrl(host + "theia/api/v1/showPaymentPage");
            transactionManager.startTransaction(this, ActivityRequestCode);
        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            Log.e(TAG, " result code " + resultCode);
            // -1 means successful  // 0 means failed
            // one error is - nativeSdkForMerchantMessage : networkError
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == ActivityRequestCode && data != null) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    for (String key : bundle.keySet()) {
                        Log.e(TAG, key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
                    }
                }
                Log.e(TAG, " data " + data.getStringExtra("nativeSdkForMerchantMessage"));
                Log.e(TAG, " data response - " + data.getStringExtra("response"));
/*
 data response - {"BANKNAME":"WALLET","BANKTXNID":"1394221115",
 "CHECKSUMHASH":"7jRCFIk6eRmrep+IhnmQrlrL43KSCSXrmM+VHP5pH0ekXaaxjt3MEgd1N9mLtWyu4VwpWexHOILCTAhybOo5EVDmAEV33rg2VAS/p0PXdk\u003d",
 "CURRENCY":"INR","GATEWAYNAME":"WALLET","MID":"EAcP3138556","ORDERID":"100620202152",
 "PAYMENTMODE":"PPI","RESPCODE":"01","RESPMSG":"Txn Success","STATUS":"TXN_SUCCESS",
 "TXNAMOUNT":"2.00","TXNDATE":"2020-06-10 16:57:45.0","TXNID":"2020061011121280011018328631290118"}
  */
    /*            Toast.makeText(this, data.getStringExtra("nativeSdkForMerchantMessage")
                        + data.getStringExtra("response"), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(TAG, " payment failed");
            }
        }
*/
   /* private void setupRecycler() {


        Items item1 = new Items("Item 1", 100), item2 = new Items("Item 2", 150);
        Items[] items = {item1, item2};

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView rv = findViewById(R.id.checkoutList);
        rv.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new itemsAdapter(this, items);
        rv.setAdapter(adapter);
    }*/
}
