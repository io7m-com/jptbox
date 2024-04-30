/*
 * Copyright © 2016 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

import com.io7m.jaffirm.core.PreconditionViolationException;
import com.io7m.jptbox.core.JPTextBoxDrawingType;
import com.io7m.jptbox.core.JPTextImage;
import com.io7m.jptbox.core.JPTextImageType;
import com.io7m.jptbox.core.JPTextImages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public abstract class JPTextBoxDrawingContract
{
  protected abstract JPTextBoxDrawingType create();

  @Rule public final ExpectedException expected = ExpectedException.none();

  @Test
  public final void testDrawBoxCaseOutsideError0()
  {
    final JPTextImageType image = JPTextImage.create(2, 2);
    final JPTextBoxDrawingType draw = this.create();

    this.expected.expect(PreconditionViolationException.class);
    draw.drawBox(image, 0, 0, 3, 3);
  }

  @Test
  public final void testDrawBoxCaseOutsideSilent0()
  {
    final JPTextImageType image = JPTextImage.create(2, 2);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 3, 3);
  }

  @Test
  public final void testDrawBoxCaseOutside0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 1, 0, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside2()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 0, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside3()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 3, 0, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside4()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 4, 0, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside5()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 4, 1, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside6()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 4, 2, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside7()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 4, 3, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside8()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 4, 4, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside9()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 3, 4, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside10()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 4, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside11()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 1, 4, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside12()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 4, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside13()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 3, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside14()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 2, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseOutside15()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 1, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }


  @Test
  public final void testDrawBoxCaseIntersect0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 1, 1, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 1, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect2()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 3, 1, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect3()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 3, 2, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect4()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 3, 3, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect5()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 3, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect6()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 1, 3, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseIntersect7()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 1, 2, 3, 3);
    draw.drawBox(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseJunction0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 2, 3, 3);
    draw.drawBox(image, 2, 4, 3, 3);
    draw.drawBox(image, 4, 3, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseJunction1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 2, 3, 3);
    draw.drawBox(image, 2, 4, 3, 3);
    draw.drawBox(image, 0, 3, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseJunction2()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 2, 3, 3);
    draw.drawBox(image, 4, 2, 3, 3);
    draw.drawBox(image, 3, 0, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseJunction3()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 2, 2, 3, 3);
    draw.drawBox(image, 4, 2, 3, 3);
    draw.drawBox(image, 3, 4, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseEmpty0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 0, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseEmpty1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 3, 0);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseSize1_0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 1, 0);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseSize0_1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 0, 1);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxCaseSize1_1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBox(image, 0, 0, 1, 1);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 1, 0, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside2()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 2, 0, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside3()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 3, 0, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside4()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 4, 0, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside5()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 4, 1, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside6()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 4, 2, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside7()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 4, 3, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside8()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 4, 4, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside9()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 3, 4, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside10()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 2, 4, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside11()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 1, 4, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside12()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 4, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside13()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 3, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside14()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 2, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseOutside15()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 1, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }


  @Test
  public final void testDrawBoxSilentCaseIntersect0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 1, 1, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 2, 1, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect2()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 3, 1, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect3()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 3, 2, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect4()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 3, 3, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect5()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 2, 3, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect6()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 1, 3, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseIntersect7()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 1, 2, 3, 3);
    draw.drawBoxSilent(image, 2, 2, 3, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseEmpty0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 0, 3);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseEmpty1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 3, 0);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseSize1_0()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 1, 0);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseSize0_1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 0, 1);
    System.out.println(JPTextImages.show(image));
  }

  @Test
  public final void testDrawBoxSilentCaseSize1_1()
  {
    final JPTextImageType image = JPTextImage.create(16, 16);
    final JPTextBoxDrawingType draw = this.create();

    draw.drawBoxSilent(image, 0, 0, 1, 1);
    System.out.println(JPTextImages.show(image));
  }
}