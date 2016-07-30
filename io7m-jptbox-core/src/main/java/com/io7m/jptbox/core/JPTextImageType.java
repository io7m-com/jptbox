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
 * The type of text images.
 */

public interface JPTextImageType
{
  /**
   * @param x The x coordinate
   * @param y The y coordinate
   *
   * @return {@code true} iff the given coordinates are inside the image
   */

  boolean isInside(
    int x,
    int y);

  /**
   * Set the character at {@code (x, y)} to {@code value}
   *
   * @param x     The X coordinate ({@code 0 <= x < width} must hold)
   * @param y     The Y coordinate ({@code 0 <= y < height} must hold)
   * @param value The character value
   */

  void put(
    int x,
    int y,
    int value);

  /**
   * Set the character at {@code (x, y)} to {@code value}. If {@code x} or
   * {@code y} is outside of the bounds of the image, no setting is performed
   * and no exceptions are raised.
   *
   * @param x     The X coordinate
   * @param y     The Y coordinate
   * @param value The character value
   */

  void putSilent(
    int x,
    int y,
    int value);

  /**
   * @return The width of the image
   */

  int width();

  /**
   * @return The height of the image
   */

  int height();

  /**
   * Retrieve a character in the image.
   *
   * @param x The X coordinate ({@code 0 <= x < width} must hold)
   * @param y The Y coordinate ({@code 0 <= y < height} must hold)
   *
   * @return The character at {@code (x, y)}
   */

  int get(
    int x,
    int y);

  /**
   * Retrieve a character in the image.
   *
   * @param x The X coordinate
   * @param y The Y coordinate
   * @param v The default value
   *
   * @return The character at {@code (x, y)}, or {@code v} iff the coordinates
   * are outside of the image
   */

  int getSilent(
    int x,
    int y,
    int v);
}
