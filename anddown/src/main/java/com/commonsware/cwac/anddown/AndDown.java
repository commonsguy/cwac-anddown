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

package com.commonsware.cwac.anddown;

/**
 * Java entry point to convert Markdown to HTML. Call the static markdownToHtml()
 * method for this.
 */
public class AndDown {
  static {
    System.loadLibrary("anddown");
  }

  /* block-level extensions */
  public static final int HOEDOWN_EXT_TABLES = (1 << 0);
  public static final int HOEDOWN_EXT_FENCED_CODE = (1 << 1);
  public static final int HOEDOWN_EXT_FOOTNOTES = (1 << 2);

	/* span-level extensions */
  public static final int HOEDOWN_EXT_AUTOLINK = (1 << 3);
  public static final int HOEDOWN_EXT_STRIKETHROUGH = (1 << 4);
  public static final int HOEDOWN_EXT_UNDERLINE = (1 << 5);
  public static final int HOEDOWN_EXT_HIGHLIGHT = (1 << 6);
  public static final int HOEDOWN_EXT_QUOTE = (1 << 7);
  public static final int HOEDOWN_EXT_SUPERSCRIPT = (1 << 8);
  public static final int HOEDOWN_EXT_MATH = (1 << 9);

	/* other flags */
  public static final int HOEDOWN_EXT_NO_INTRA_EMPHASIS = (1 << 11);
  public static final int HOEDOWN_EXT_SPACE_HEADERS = (1 << 12);
  public static final int HOEDOWN_EXT_MATH_EXPLICIT = (1 << 13);

	/* negative flags */
  public static final int HOEDOWN_EXT_DISABLE_INDENTED_CODE = (1 << 14);

  public static final int HOEDOWN_HTML_SKIP_HTML = (1 << 0);
  public static final int HOEDOWN_HTML_ESCAPE = (1 << 1);
  public static final int HOEDOWN_HTML_HARD_WRAP = (1 << 2);
  public static final int HOEDOWN_HTML_USE_XHTML = (1 << 3);

  /**
   * Given Markdown, returns HTML. 'Nuff said.
   *
   * @param raw Markdown-formatted string
   * @return HTML-formatted string
   */
  public String markdownToHtml(String raw) {
    return(markdownToHtml(raw, 0, 0));
  }

  public native String markdownToHtml(String raw, int extensions, int flags);
}
