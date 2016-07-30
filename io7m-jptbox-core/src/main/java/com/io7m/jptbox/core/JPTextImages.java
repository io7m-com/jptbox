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

package com.io7m.jptbox.core;

import com.io7m.junreachable.UnreachableCodeException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Pattern;

/**
 * Functions over text images.
 */

public final class JPTextImages
{
  private static final Pattern TRAILING_WHITESPACE = Pattern.compile("\\s+$");

  private JPTextImages()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Convert the given image to a string.
   *
   * @param image The image
   *
   * @return A string representation of the image
   */

  public static String show(final JPTextImageType image)
  {
    try (final StringWriter writer =
           new StringWriter(image.width() * image.height())) {

      final StringBuilder sb = new StringBuilder(image.width());
      for (int y = 0; y < image.height(); ++y) {
        sb.setLength(0);
        for (int x = 0; x < image.width(); ++x) {
          sb.appendCodePoint(image.get(x, y));
        }

        final String line =
          JPTextImages.TRAILING_WHITESPACE.matcher(sb.toString()).replaceAll("");
        writer.write(line);
        writer.write("\n");
      }

      return writer.toString();
    } catch (final IOException e) {
      throw new UnreachableCodeException(e);
    }
  }
}
