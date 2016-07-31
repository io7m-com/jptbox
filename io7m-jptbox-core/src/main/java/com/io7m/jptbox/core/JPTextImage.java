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

import org.valid4j.Assertive;

/**
 * The default implementation of the {@link JPTextImageType} interface.
 */

public final class JPTextImage implements JPTextImageType
{
  private final int width;
  private final int height;
  private final int[] chars;

  private JPTextImage(
    final int in_width,
    final int in_height)
  {
    Assertive.require(
      in_width > 0,
      "Width (%d) must be positive",
      Integer.valueOf(in_width));
    Assertive.require(
      in_height > 0,
      "Height (%d) must be positive",
      Integer.valueOf(in_height));

    this.width = in_width;
    this.height = in_height;
    this.chars = new int[this.width * this.height];

    for (int index = 0; index < this.chars.length; ++index) {
      this.chars[index] = ' ';
    }
  }

  /**
   * Create a new image.
   *
   * @param width  The width
   * @param height The height
   *
   * @return A new image
   */

  public static JPTextImageType create(
    final int width,
    final int height)
  {
    return new JPTextImage(width, height);
  }

  @Override
  public boolean isInside(
    final int x,
    final int y)
  {
    return x >= 0 && x < this.width && y >= 0 && y < this.height;
  }

  @Override
  public void put(
    final int x,
    final int y,
    final int value)
  {
    this.checkXY(x, y);
    this.chars[(y * this.width) + x] = value;
  }

  @Override
  public void putSilent(
    final int x,
    final int y,
    final int value)
  {
    if (this.isInside(x, y)) {
      this.chars[(y * this.width) + x] = value;
    }
  }

  @Override
  public int width()
  {
    return this.width;
  }

  @Override
  public int height()
  {
    return this.height;
  }

  @Override
  public int get(
    final int x,
    final int y)
  {
    this.checkXY(x, y);
    return this.chars[(y * this.width) + x];
  }

  @Override
  public int getSilent(
    final int x,
    final int y,
    final int v)
  {
    if (this.isInside(x, y)) {
      return this.chars[(y * this.width) + x];
    }

    return v;
  }

  private void checkXY(
    final int x,
    final int y)
  {
    Assertive.require(
      x >= 0,
      "X (%d) must be >= 0",
      Integer.valueOf(x));
    Assertive.require(
      x < this.width,
      "X (%d) must be < width (%d)",
      Integer.valueOf(x),
      Integer.valueOf(this.width));

    Assertive.require(
      y >= 0,
      "Y (%d) must be >= 0",
      Integer.valueOf(y));
    Assertive.require(
      y < this.height,
      "Y (%d) must be < height (%d)",
      Integer.valueOf(y),
      Integer.valueOf(this.height));
  }
}
