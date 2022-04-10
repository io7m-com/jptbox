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

package com.io7m.jptbox.core;

import com.io7m.jaffirm.core.Preconditions;
import java.util.Objects;

/**
 * The default implementation of the {@link JPTextBoxDrawingType} interface.
 */

public final class JPTextBoxDrawing implements JPTextBoxDrawingType
{
  private static final JPTextBoxDrawingType INSTANCE = new JPTextBoxDrawing();

  private JPTextBoxDrawing()
  {

  }

  /**
   * @return Access to the default instance
   */

  public static JPTextBoxDrawingType get()
  {
    return INSTANCE;
  }

  private static void merge(
    final JPTextImageType image,
    final int x,
    final int y,
    final int new_char)
  {
    final int replace = JPTextBoxLightMaps.mergeCharacter(image.get(x, y), new_char);
    image.put(x, y, replace);
  }

  private static void mergeSilent(
    final JPTextImageType image,
    final int x,
    final int y,
    final int new_char)
  {
    if (image.isInside(x, y)) {
      final int replace = JPTextBoxLightMaps.mergeCharacter(image.get(x, y), new_char);
      image.putSilent(x, y, replace);
    }
  }

  @Override
  public void drawBox(
    final JPTextImageType image,
    final int base_x,
    final int base_y,
    final int width,
    final int height)
  {
    Objects.requireNonNull(image, "Image");

    final int x_max = width - 1;
    final int y_max = height - 1;

    if (width == 0 || height == 0) {
      return;
    }

    Preconditions.checkPreconditionV(
      image.isInside(base_x, base_y),
      "Top left corner (%d, %d) must be inside the image",
      Integer.valueOf(base_x),
      Integer.valueOf(base_y));
    Preconditions.checkPreconditionV(
      image.isInside(x_max, y_max),
      "Bottom right corner (%d, %d) must be inside the image",
      Integer.valueOf(x_max),
      Integer.valueOf(y_max));

    if (width == 1 && height == 1) {
      merge(image, base_x, base_y, '□');
      return;
    }

    for (int y = 1; y <= y_max - 1; ++y) {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, y);
      merge(image, image_x, image_y, '│');
    }

    for (int y = 1; y <= y_max - 1; ++y) {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, y);
      merge(image, image_x, image_y, '│');
    }

    for (int x = 1; x <= x_max - 1; ++x) {
      final int image_x = Math.addExact(base_x, x);
      final int image_y = Math.addExact(base_y, 0);
      merge(image, image_x, image_y, '─');
    }

    for (int x = 1; x <= x_max - 1; ++x) {
      final int image_x = Math.addExact(base_x, x);
      final int image_y = Math.addExact(base_y, y_max);
      merge(image, image_x, image_y, '─');
    }

    {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, 0);
      merge(image, image_x, image_y, '┌');
    }

    {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, y_max);
      merge(image, image_x, image_y, '└');
    }

    {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, y_max);
      merge(image, image_x, image_y, '┘');
    }

    {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, 0);
      merge(image, image_x, image_y, '┐');
    }
  }

  @Override
  public void drawBoxSilent(
    final JPTextImageType image,
    final int base_x,
    final int base_y,
    final int width,
    final int height)
  {
    Objects.requireNonNull(image, "Image");

    if (width == 0 || height == 0) {
      return;
    }

    if (width == 1 && height == 1) {
      mergeSilent(image, base_x, base_y, '□');
      return;
    }

    final int x_max = width - 1;
    final int y_max = height - 1;

    for (int y = 1; y <= y_max - 1; ++y) {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, y);
      mergeSilent(image, image_x, image_y, '│');
    }

    for (int y = 1; y <= y_max - 1; ++y) {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, y);
      mergeSilent(image, image_x, image_y, '│');
    }

    for (int x = 1; x <= x_max - 1; ++x) {
      final int image_x = Math.addExact(base_x, x);
      final int image_y = Math.addExact(base_y, 0);
      mergeSilent(image, image_x, image_y, '─');
    }

    for (int x = 1; x <= x_max - 1; ++x) {
      final int image_x = Math.addExact(base_x, x);
      final int image_y = Math.addExact(base_y, y_max);
      mergeSilent(image, image_x, image_y, '─');
    }

    {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, 0);
      mergeSilent(image, image_x, image_y, '┌');
    }

    {
      final int image_x = Math.addExact(base_x, 0);
      final int image_y = Math.addExact(base_y, y_max);
      mergeSilent(image, image_x, image_y, '└');
    }

    {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, y_max);
      mergeSilent(image, image_x, image_y, '┘');
    }

    {
      final int image_x = Math.addExact(base_x, x_max);
      final int image_y = Math.addExact(base_y, 0);
      mergeSilent(image, image_x, image_y, '┐');
    }
  }
}
