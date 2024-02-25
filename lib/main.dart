import 'package:flutter/material.dart';
import 'package:mrg/screens/welcome_page.dart';
import 'package:mrg/theme/theme.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: lightMode,
      debugShowCheckedModeBanner: false,
      home: const WelcomePage(),
    );
  }
}
