package com.rachelgrau.rachel.health4theworldstroke.Activities;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.rachelgrau.rachel.health4theworldstroke.R;
import java.io.InputStream;
import java.util.Random;


public class chatBotQuotes extends AppCompatActivity {


    String Image_Url[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_quotes);

        // Linkes of all the quotes
        Image_Url =new String[]{"%22An+unexaminced+life%22.png",
                "%22Believe+you+can%22.png",
                "%22Change+your+thoughts%22.png",
                "%22Do+one+thing%22.png",
                "%22Every+strike%22.png",
                "%22Good%2C+better%2C+best%22.png",
                "%22Health+is+the+greatest%22.png",
                "%22I+attribute%22.png",
                "%22I+can't+change%22.png",
                "%22If+opportunity+doesn't%22.png",
                "%22If+you+can+dream+it%22.png",
                "%22If+you+fell+down%22.png",
                "%22It+always+seems%22.png",
                "%22It+is+never+too+late%22.png",
                "%22Keep+your+face%22.png",
                "%22Let+us+make%22.png",
                "%22Let+us+remember%22.png",
                "%22Life+isn't+about%22.png",
                "%22My+mission+in+life%22.png",
                "%22Never%2C+never%2C+never%22.png",
                "%22Nothing+is+impossible%22.png",
                "%22Only+I+can+change%22.png",
                "%22Optimism+is+the+faith%22.png",
                "%22Perfection+is+not%22.png",
                "%22Problems+are+not%22.png",
                "%22Put+your+heart%22.png",
                "%22Setting+goals+is%22.png",
                "%22Someone+is+sitting%22.png",
                "%22Start+where+you+are%22.png",
                "%22Strive+not+to+be+a+success%22.png",
                "%22The+best+preparation%22.png",
                "%22The+most+common%22.png",
                "%22The+most+difficult+thing%22.png",
                "%22Thousands+of+candles%22.png",
                "%22Try+to+be+a+rainbow%22.png",
                "%22Twenty+years%22.png",
                "%22Two+roads+diverge%22.png",
                "%22We+can't+help+everyone%22.png",
                "%22We+know+what%22.png",
                "%22What+we+think%22.png",
                "%22Whatever+the+mind+of+man%22.png",
                "%22With+the+new+day%22.png",
                "%22You+are+never+too+old%22.png",
                "%22You+can't+cross+the+sea%22.png",
                "%22You+miss+100%25%22.png",
                "%22You+must+do+the%22.png",
                "%22Your+time+is+limited%22.png",
                "80%25+of+success%22.png",
                "Life+is+10%25%22.png",
                "%E2%80%9CAlways+do+your+best.%22.png"};

        Random rand = new Random();

        int  RandIndex = rand.nextInt(Image_Url.length); //Randome Index of the array to show a randome quote
        //length of the array is the maximum and 0 is our minimum

        new DownloadImageTask((ImageView) findViewById(R.id.quoteView))
                .execute("https://s3-us-west-1.amazonaws.com/h4twappquotes/" + Image_Url[RandIndex]);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
