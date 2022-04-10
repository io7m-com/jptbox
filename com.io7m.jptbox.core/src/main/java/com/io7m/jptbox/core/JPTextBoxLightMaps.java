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

import com.io7m.junreachable.UnreachableCodeException;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntMaps;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

/**
 * Maps used to merge characters when drawing boxes.
 */

public final class JPTextBoxLightMaps
{
  /**
   * Mappings from ┐
   */

  public static final Int2IntMap EXISTS_TOP_RIGHT_CORNER;

  /**
   * Mappings from ┌
   */

  public static final Int2IntMap EXISTS_TOP_LEFT_CORNER;

  /**
   * Mappings from └
   */

  public static final Int2IntMap EXISTS_BOTTOM_LEFT_CORNER;

  /**
   * Mappings from ┘
   */

  public static final Int2IntMap EXISTS_BOTTOM_RIGHT_CORNER;

  /**
   * Mappings from ─
   */

  public static final Int2IntMap EXISTS_HORIZONTAL;

  /**
   * Mappings from │
   */

  public static final Int2IntMap EXISTS_VERTICAL;

  /**
   * Mappings from ┼
   */

  public static final Int2IntMap EXISTS_CROSS;

  /**
   * Mappings from ┤
   */

  public static final Int2IntMap EXISTS_JUNCTION_LEFT;

  /**
   * Mappings from ├
   */

  public static final Int2IntMap EXISTS_JUNCTION_RIGHT;

  /**
   * Mappings from ┬
   */

  public static final Int2IntMap EXISTS_JUNCTION_DOWN;

  /**
   * Mappings from ┴
   */

  public static final Int2IntMap EXISTS_JUNCTION_UP;

  static {
    EXISTS_TOP_RIGHT_CORNER = existsTopRightMap();
    EXISTS_TOP_LEFT_CORNER = existsTopLeftMap();
    EXISTS_BOTTOM_LEFT_CORNER = existsBottomLeftMap();
    EXISTS_BOTTOM_RIGHT_CORNER = existsBottomRightMap();
    EXISTS_HORIZONTAL = existsHorizontalMap();
    EXISTS_VERTICAL = existsVerticalMap();
    EXISTS_CROSS = existsCrossMap();
    EXISTS_JUNCTION_LEFT = existsJunctionLeftMap();
    EXISTS_JUNCTION_RIGHT = existsJunctionRightMap();
    EXISTS_JUNCTION_DOWN = existsJunctionDownMap();
    EXISTS_JUNCTION_UP = existsJunctionUpMap();
  }

  private static Int2IntMap existsJunctionUpMap()
  {
    // existing: ┴
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '┼');

    m.put('┬', '┼');
    m.put('┴', '┴');

    m.put('┘', '┴');
    m.put('└', '┴');

    m.put('┌', '┼');
    m.put('┐', '┼');

    m.put('│', '┼');
    m.put('─', '┴');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsJunctionDownMap()
  {
    // existing: ┬
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '┼');

    m.put('┬', '┬');
    m.put('┴', '┼');

    m.put('┘', '┼');
    m.put('└', '┼');

    m.put('┌', '┬');
    m.put('┐', '┬');

    m.put('│', '┼');
    m.put('─', '┬');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsJunctionRightMap()
  {
    // existing: ├
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '├');

    m.put('┬', '┼');
    m.put('┴', '┼');

    m.put('┘', '├');
    m.put('└', '├');

    m.put('┌', '├');
    m.put('┐', '┼');

    m.put('│', '├');
    m.put('─', '┼');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsJunctionLeftMap()
  {
    // existing: ┤
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┤');
    m.put('├', '┼');

    m.put('┬', '┼');
    m.put('┴', '┼');

    m.put('┘', '┤');
    m.put('└', '┼');

    m.put('┌', '┼');
    m.put('┐', '┤');

    m.put('│', '┤');
    m.put('─', '┼');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsCrossMap()
  {
    // existing: ┼
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '┼');

    m.put('┬', '┼');
    m.put('┴', '┼');

    m.put('┘', '┼');
    m.put('└', '┼');

    m.put('┌', '┼');
    m.put('┐', '┼');

    m.put('│', '┼');
    m.put('─', '┼');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsVerticalMap()
  {
    // existing: │
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┤');
    m.put('├', '├');

    m.put('┬', '┼');
    m.put('┴', '┼');

    m.put('┘', '┤');
    m.put('└', '├');

    m.put('┌', '├');
    m.put('┐', '┤');

    m.put('│', '│');
    m.put('─', '┼');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsHorizontalMap()
  {
    // existing: ─
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '┼');

    m.put('┬', '┬');
    m.put('┴', '┴');

    m.put('┘', '┴');
    m.put('└', '┴');

    m.put('┌', '┬');
    m.put('┐', '┬');

    m.put('│', '┼');
    m.put('─', '─');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsBottomRightMap()
  {
    // existing: ┘
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┤');
    m.put('├', '┼');

    m.put('┬', '┼');
    m.put('┴', '┴');

    m.put('┘', '┘');
    m.put('└', '┴');

    m.put('┌', '┼');
    m.put('┐', '┤');

    m.put('│', '┤');
    m.put('─', '┴');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsBottomLeftMap()
  {
    // existing: └
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '├');

    m.put('┬', '┼');
    m.put('┴', '┴');

    m.put('┘', '┴');
    m.put('└', '└');

    m.put('┌', '├');
    m.put('┐', '┼');

    m.put('│', '├');
    m.put('─', '┴');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsTopLeftMap()
  {
    // existing: ┌
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┼');
    m.put('├', '├');

    m.put('┬', '┬');
    m.put('┴', '┼');

    m.put('┘', '┼');
    m.put('└', '├');

    m.put('┌', '┌');
    m.put('┐', '┬');

    m.put('│', '├');
    m.put('─', '┬');

    return Int2IntMaps.unmodifiable(m);
  }

  private static Int2IntMap existsTopRightMap()
  {
    // existing: ┐
    final Int2IntOpenHashMap m = new Int2IntOpenHashMap(10);
    m.put('┤', '┤');
    m.put('├', '┼');

    m.put('┬', '┬');
    m.put('┴', '┼');

    m.put('┘', '┤');
    m.put('└', '┼');

    m.put('┌', '┬');
    m.put('┐', '┐');

    m.put('│', '┤');
    m.put('─', '┬');

    return Int2IntMaps.unmodifiable(m);
  }

  private JPTextBoxLightMaps()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Merge the new character with the existing character.
   *
   * @param existing_char The existing character
   * @param new_char      The new character
   *
   * @return A character representing the merge
   */

  // CHECKSTYLE:OFF
  public static int mergeCharacter(
    final int existing_char,
    final int new_char)
  {
    switch (existing_char) {

      case '┐': {
        if (EXISTS_TOP_RIGHT_CORNER.containsKey(new_char)) {
          return EXISTS_TOP_RIGHT_CORNER.get(new_char);
        }
        return new_char;
      }

      case '┌': {
        if (EXISTS_TOP_LEFT_CORNER.containsKey(new_char)) {
          return EXISTS_TOP_LEFT_CORNER.get(new_char);
        }
        return new_char;
      }

      case '└': {
        if (EXISTS_BOTTOM_LEFT_CORNER.containsKey(new_char)) {
          return EXISTS_BOTTOM_LEFT_CORNER.get(new_char);
        }
        return new_char;
      }

      case '┘': {
        if (EXISTS_BOTTOM_RIGHT_CORNER.containsKey(new_char)) {
          return EXISTS_BOTTOM_RIGHT_CORNER.get(new_char);
        }
        return new_char;
      }

      case '─': {
        if (EXISTS_HORIZONTAL.containsKey(new_char)) {
          return EXISTS_HORIZONTAL.get(new_char);
        }
        return new_char;
      }

      case '│': {
        if (EXISTS_VERTICAL.containsKey(new_char)) {
          return EXISTS_VERTICAL.get(new_char);
        }
        return new_char;
      }

      case '┼': {
        if (EXISTS_CROSS.containsKey(new_char)) {
          return EXISTS_CROSS.get(new_char);
        }
        return new_char;
      }

      case '┤': {
        if (EXISTS_JUNCTION_LEFT.containsKey(new_char)) {
          return EXISTS_JUNCTION_LEFT.get(new_char);
        }
        return new_char;
      }

      case '├': {
        if (EXISTS_JUNCTION_RIGHT.containsKey(new_char)) {
          return EXISTS_JUNCTION_RIGHT.get(new_char);
        }
        return new_char;
      }

      case '┬': {
        if (EXISTS_JUNCTION_DOWN.containsKey(new_char)) {
          return EXISTS_JUNCTION_DOWN.get(new_char);
        }
        return new_char;
      }

      case '┴': {
        if (EXISTS_JUNCTION_UP.containsKey(new_char)) {
          return EXISTS_JUNCTION_UP.get(new_char);
        }
        return new_char;
      }
    }

    // CHECKSTYLE:ON
    return new_char;
  }
}
