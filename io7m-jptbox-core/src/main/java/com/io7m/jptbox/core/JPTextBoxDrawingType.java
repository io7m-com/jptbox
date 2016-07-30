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

/**
 * A box drawing interface.
 */

public interface JPTextBoxDrawingType
{
  /**
   * Draw a box.
   *
   * @param image  The target image
   * @param base_x The X value of the top left corner
   * @param base_y The Y value of the top left corner
   * @param width  The width of the box
   * @param height The height of the box
   */

  void drawBox(
    JPTextImageType image,
    int base_x,
    int base_y,
    int width,
    int height);

  /**
   * Draw a box without raising any exceptions if any part of the box is
   * outside of the image.
   *
   * @param image  The target image
   * @param base_x The X value of the top left corner
   * @param base_y The Y value of the top left corner
   * @param width  The width of the box
   * @param height The height of the box
   */

  void drawBoxSilent(
    JPTextImageType image,
    int base_x,
    int base_y,
    int width,
    int height);
}
