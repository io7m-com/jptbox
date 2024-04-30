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
import com.io7m.jptbox.core.JPTextImageType;
import com.io7m.jptbox.core.JPTextImages;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public abstract class JPTextImageContract
{
  @Rule public final ExpectedException expected = ExpectedException.none();

  protected abstract JPTextImageType create(
    int width,
    int height);

  @Test
  public final void testNegativeWidth()
  {
    this.expected.expect(PreconditionViolationException.class);
    this.create(-1, 1);
  }

  @Test
  public final void testZeroWidth()
  {
    this.expected.expect(PreconditionViolationException.class);
    this.create(0, 1);
  }

  @Test
  public final void testNegativeHeight()
  {
    this.expected.expect(PreconditionViolationException.class);
    this.create(1, -1);
  }

  @Test
  public final void testZeroHeight()
  {
    this.expected.expect(PreconditionViolationException.class);
    this.create(1, 0);
  }

  @Test
  public final void testGetOutOfBoundsNegativeX()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.get(-1, 0);
  }

  @Test
  public final void testGetOutOfBoundsPositiveX()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.get(2, 0);
  }

  @Test
  public final void testGetOutOfBoundsNegativeY()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.get(0, -1);
  }

  @Test
  public final void testGetOutOfBoundsPositiveY()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.get(0, 2);
  }

  @Test
  public final void testGetOutOfBoundsSilentNegativeX()
  {
    final JPTextImageType image = this.create(1, 2);
    Assert.assertEquals('Q', image.getSilent(-1, 0, 'Q'));
  }

  @Test
  public final void testGetOutOfBoundsSilentPositiveX()
  {
    final JPTextImageType image = this.create(1, 2);
    Assert.assertEquals('Q', image.getSilent(2, 0, 'Q'));
  }

  @Test
  public final void testGetOutOfBoundsSilentNegativeY()
  {
    final JPTextImageType image = this.create(1, 2);
    Assert.assertEquals('Q', image.getSilent(0, -1, 'Q'));
  }

  @Test
  public final void testGetOutOfBoundsSilentPositiveY()
  {
    final JPTextImageType image = this.create(1, 2);
    Assert.assertEquals('Q', image.getSilent(0, 2, 'Q'));
  }

  @Test
  public final void testIdentities()
  {
    final JPTextImageType image = this.create(1, 2);
    Assert.assertEquals(1L, (long) image.width());
    Assert.assertEquals(2L, (long) image.height());

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertEquals((long) ' ', (long) image.get(x, y));
      }
    }

    image.put(0, 0, (int) 'X');
    Assert.assertEquals((long) 'X', (long) image.get(0, 0));

    image.put(0, 1, (int) 'Y');
    Assert.assertEquals((long) 'Y', (long) image.get(0, 1));

    image.putSilent(0, 0, (int) 'A');
    Assert.assertEquals((long) 'A', (long) image.getSilent(0, 0, 'Z'));

    image.putSilent(0, 1, (int) 'B');
    Assert.assertEquals((long) 'B', (long) image.getSilent(0, 1, 'Z'));
  }

  @Test
  public final void testPutOutOfBoundsNegativeX()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.put(-1, 0, 'Q');
  }

  @Test
  public final void testPutOutOfBoundsPositiveX()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.put(2, 0, 'Q');
  }

  @Test
  public final void testPutOutOfBoundsNegativeY()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.put(0, -1, 'Q');
  }

  @Test
  public final void testPutOutOfBoundsPositiveY()
  {
    final JPTextImageType image = this.create(1, 2);

    this.expected.expect(PreconditionViolationException.class);
    image.put(0, 2, 'Q');

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertNotEquals('Q', image.get(x, y));
      }
    }
  }

  @Test
  public final void testPutOutOfBoundsSilentNegativeX()
  {
    final JPTextImageType image = this.create(1, 2);
    image.putSilent(-1, 0, 'Q');

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertNotEquals('Q', image.get(x, y));
      }
    }
  }

  @Test
  public final void testPutOutOfBoundsSilentPositiveX()
  {
    final JPTextImageType image = this.create(1, 2);
    image.putSilent(2, 0, 'Q');

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertNotEquals('Q', image.get(x, y));
      }
    }
  }

  @Test
  public final void testPutOutOfBoundsSilentNegativeY()
  {
    final JPTextImageType image = this.create(1, 2);
    image.putSilent(0, -1, 'Q');

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertNotEquals('Q', image.get(x, y));
      }
    }
  }

  @Test
  public final void testPutOutOfBoundsSilentPositiveY()
  {
    final JPTextImageType image = this.create(1, 2);
    image.putSilent(0, 2, 'Q');

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 1; ++x) {
        Assert.assertNotEquals('Q', image.get(x, y));
      }
    }
  }

  @Test
  public final void testShow()
  {
    final JPTextImageType image = this.create(2, 2);

    for (int y = 0; y < 2; ++y) {
      for (int x = 0; x < 2; ++x) {
        image.put(x, y, (int) (Math.random() * Character.MAX_VALUE));
      }
    }

    System.out.println(JPTextImages.show(image));
  }
}
