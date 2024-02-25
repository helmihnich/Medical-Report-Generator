import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';
import 'package:line_icons/line_icons.dart';
import 'package:mrg/screens/consult_page.dart';
import 'package:mrg/theme/theme.dart';

class HomePage extends StatelessWidget {
  // ignore: use_key_in_widget_constructors
  const HomePage({Key? key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          children: [
            const SizedBox(
              height: 25.0,
            ),
            const Text(
              "Patient's list",
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 16),
            DataTable(
              columns: const [
                DataColumn(
                  label: Text("FirstName"),
                ),
                DataColumn(
                  label: Text("LastName"),
                ),
                DataColumn(
                  label: Text("Appointment"),
                ),
                DataColumn(
                  label: Text("Consult"),
                ),
              ],
              rows: _createRows(context), // Pass context here
              dividerThickness: 5,
              showBottomBorder: true,
              headingTextStyle: const TextStyle(
                fontWeight: FontWeight.bold,
                color: Colors.white,
              ),
              headingRowColor: MaterialStateProperty.resolveWith(
                (states) => Colors.black,
              ),
            ),
          ],
        ),
      ),
      bottomNavigationBar: Container(
        color: Colors.white,
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 15.0, vertical: 20.0),
          child: GNav(
            backgroundColor: Colors.white,
            color: Colors.black,
            activeColor: Colors.white,
            tabBackgroundColor: lightColorScheme.primary,
            gap: 8,
            onTabChange: (index) {
              print(index);
            },
            padding: const EdgeInsets.all(16),
            tabs: const [
              GButton(
                icon: Icons.home,
                text: "Home",
              ),
              GButton(
                icon: Icons.search,
                text: "Search",
              ),
              GButton(
                icon: Icons.settings,
                text: "Settings",
              ),
              GButton(
                icon: LineIcons.user,
                text: 'Profile',
              ),
            ],
          ),
        ),
      ),
    );
  }
}

List<DataRow> _createRows(BuildContext context) {
  // Accept context here
  return [
    DataRow(cells: [
      const DataCell(Text('Firas')),
      const DataCell(Text('Hajlaoui')),
      const DataCell(Text('10:00 AM')),
      DataCell(
        ElevatedButton(
          onPressed: () {
            // Handle button press
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => const ConsultPage(
                  firstName: 'Firas',
                  lastName: 'Hajlaoui',
                  age: '30',
                  problem: 'Headache',
                  appointmentTime: '10:00 AM',
                ),
              ),
            );
          },
          child: const Text("Consult"),
        ),
      ),
    ]),
    DataRow(cells: [
      const DataCell(Text('Helmi')),
      const DataCell(Text('Hnich')),
      const DataCell(Text('11:40')),
      DataCell(
        ElevatedButton(
          onPressed: () {
            // Navigate to ConsultPage when button is pressed
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => const ConsultPage(
                  firstName: 'John',
                  lastName: 'Doe',
                  age: '30',
                  problem: 'Headache',
                  appointmentTime: '10:00 AM',
                ),
              ),
            );
          },
          child: const Text("Consult"),
        ),
      ),
    ]),
  ];
}
