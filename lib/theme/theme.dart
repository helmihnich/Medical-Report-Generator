import 'package:flutter/material.dart';

const lightColorScheme = ColorScheme(
  brightness: Brightness.light,
  primary: Color(0xff416fdf),
  onPrimary: Color(0xffffffff),
  secondary: Color(0xff6eaee7),
  onSecondary: Color(0xFfffffFF),
  error: Color(0xffba1a1a),
  onError: Color(0xffffffff),
  background: Color(0xfffcfdf6),
  onBackground: Color(0xff1a1c18),
  shadow: Color(0xff000000),
  outlineVariant: Color(0xfff9faf3),
  surface: Color(0xfff9faf3),
  onSurface: Color(0xff1a1c18),
);

const darkColorScheme = ColorScheme(
  brightness: Brightness.dark,
  primary: Color(0xff416fdf),
  onPrimary: Color(0xffffffff),
  secondary: Color(0xff6eaee7),
  onSecondary: Color(0xFfffffFF),
  error: Color(0xffba1a1a),
  onError: Color(0xffffffff),
  background: Color(0xfffcfdf6),
  onBackground: Color(0xff1a1c18),
  shadow: Color(0xff000000),
  outlineVariant: Color(0xfff9faf3),
  surface: Color(0xfff9faf3),
  onSurface: Color(0xff1a1c18),
);

ThemeData lightMode = ThemeData(
    useMaterial3: true,
    brightness: Brightness.light,
    colorScheme: lightColorScheme,
    elevatedButtonTheme: ElevatedButtonThemeData(
        style: ButtonStyle(
            backgroundColor:
                const MaterialStatePropertyAll<Color>(Color(0xFF201658)),
            foregroundColor:
                const MaterialStatePropertyAll<Color>(Colors.white),
            elevation: const MaterialStatePropertyAll<double>(5.0),
            padding: const MaterialStatePropertyAll<EdgeInsets>(
                EdgeInsets.symmetric(horizontal: 20, vertical: 18)),
            shape: MaterialStatePropertyAll<RoundedRectangleBorder>(
                RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(16),
            )))));

ThemeData darkMode = ThemeData(
    useMaterial3: true,
    brightness: Brightness.dark,
    colorScheme: darkColorScheme);
