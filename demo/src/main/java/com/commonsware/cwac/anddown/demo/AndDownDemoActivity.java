package com.commonsware.cwac.anddown.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.util.TimingLogger;
import android.widget.TextView;
import com.commonsware.cwac.anddown.AndDown;

public class AndDownDemoActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    TextView tv=(TextView)findViewById(R.id.text);

    TimingLogger timings = new TimingLogger("AndDown", "onCreate");
    
    String raw=readRawTextFile(this, R.raw.readme);
    
    timings.addSplit("read raw");
    
    AndDown converter=new AndDown();
    
    timings.addSplit("instantiated AndDown");
    
    String cooked=converter.markdownToHtml(raw);
    
    timings.addSplit("convert to HTML");
    
    CharSequence cs=Html.fromHtml(cooked);
    
    timings.addSplit("convert to Spanned");
    timings.dumpToLog();
    
    tv.setText(cs);
  }

  public static String readRawTextFile(Context ctx, int resId) {
    InputStream inputStream=ctx.getResources().openRawResource(resId);
    InputStreamReader inputreader=new InputStreamReader(inputStream);
    BufferedReader buffreader=new BufferedReader(inputreader);
    String line;
    StringBuilder text=new StringBuilder();

    try {
      while ((line=buffreader.readLine())!=null) {
        text.append(line);
        text.append('\n');
      }
    }
    catch (IOException e) {
      return null;
    }
    return text.toString();
  }
}