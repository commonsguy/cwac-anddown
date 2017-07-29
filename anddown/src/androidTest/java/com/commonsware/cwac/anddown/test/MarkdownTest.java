/***
 Copyright (c) 2013-2016 CommonsWare, LLC

 Licensed under the Apache License, Version 2.0 (the "License"); you may
 not use this file except in compliance with the License. You may obtain
 a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

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
