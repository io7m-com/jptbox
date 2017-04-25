/*
 * Copyright © 2016 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jptbox.tests.core;

import com.io7m.jptbox.core.JPTextBoxDrawing;
import com.io7m.jptbox.core.JPTextBoxDrawingType;
import com.io7m.jptbox.core.JPTextImage;
import com.io7m.jptbox.core.JPTextImageType;
import com.io7m.jptbox.core.JPTextImages;

public final class JPTextBoxDrawingDemo
{
  private JPTextBoxDrawingDemo()
  {

  }

  public static void main(final String[] args)
  {
    final JPTextImageType image = JPTextImage.create(80, 10);
    final JPTextBoxDrawingType draw = JPTextBoxDrawing.get();

    draw.drawBox(image, 0, 0, 30, 3);
    draw.drawBox(image, 29, 0, 10, 3);
    draw.drawBox(image, 38, 0, 10, 3);

    draw.drawBox(image, 0, 2, 30, 3);
    draw.drawBox(image, 29, 2, 10, 3);
    draw.drawBox(image, 38, 2, 10, 3);

    System.out.println(JPTextImages.show(image));
  }

}
