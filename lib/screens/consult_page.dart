import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:line_icons/line_icons.dart';
import 'package:mrg/theme/theme.dart';

class ConsultPage extends StatefulWidget {
  final String firstName;
  final String lastName;
  final String age;
  final String problem;
  final String appointmentTime;

  const ConsultPage({
    Key? key,
    required this.firstName,
    required this.lastName,
    required this.age,
    required this.problem,
    required this.appointmentTime,
  }) : super(key: key);

  @override
  State<ConsultPage> createState() => _ConsultPageState();
}

class _ConsultPageState extends State<ConsultPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Consultation'),
        iconTheme: const IconThemeData(color: Colors.white),
        backgroundColor: Colors.transparent,
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const CircleAvatar(
                radius: 70,
                backgroundImage: AssetImage("assets/images/avatar.png"),
                backgroundColor: Colors.white,
              ),
              const SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ListTile(
                    title: const Text(
                      "Name",
                      style: TextStyle(
                        color: Colors.black87,
                        fontWeight: FontWeight.w700,
                        fontSize: 25,
                      ),
                    ),
                    subtitle: Text(
                      '${widget.firstName} ${widget.lastName}',
                      style: const TextStyle(fontSize: 25),
                    ),
                  )
                ],
              ),
            ],
          ),
        ),
        // ),
        // bottomNavigationBar: Container(
        //     color: Colors.white,
        //     child: Padding(
        //       padding:
        //           const EdgeInsets.symmetric(horizontal: 15.0, vertical: 20.0),
        //       child: GNav(
        //         backgroundColor: Colors.white,
        //         color: Colors.black,
        //         activeColor: Colors.white,
        //         tabBackgroundColor: lightColorScheme.primary,
        //         gap: 8,
        //         onTabChange: (index) {
        //           print(index);
        //         },
        //         padding: const EdgeInsets.all(16),
        //         tabs: const [
        //           GButton(
        //             icon: Icons.home,
        //             text: "Home",
        //           ),
        //           GButton(
        //             icon: Icons.search,
        //             text: "Search",
        //           ),
        //           GButton(
        //             icon: Icons.settings,
        //             text: "Settings",
        //           ),
        //           GButton(
        //             icon: LineIcons.user,
        //             text: 'Profile',
        //           ),
        //         ],
        //       ),
        //     )
      ),
    );
  }
}
