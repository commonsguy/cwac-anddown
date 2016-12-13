package com.commonsware.cwac.anddown.test;

import android.support.test.runner.AndroidJUnit4;
import com.commonsware.cwac.anddown.AndDown;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MarkdownTest {
  @Test
  public void testSimple() {
    AndDown andDown=new AndDown();

    Assert.assertEquals("<p>Hello, world</p>",
      andDown.markdownToHtml("Hello, world").trim());
    Assert.assertEquals("<p>This <q>contains</q> a quote</p>",
      andDown.markdownToHtml("This \"contains\" a quote",
        AndDown.HOEDOWN_EXT_QUOTE, 0).trim());
  }
}
