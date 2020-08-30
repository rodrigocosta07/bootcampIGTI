import 'package:flutter/material.dart';

void main() {
  runApp(Hello());
}

class Hello extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Material(
       color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Image.asset("assets/iconeDesafio.png", width: 90.0),
            Row(
              mainAxisAlignment: MainAxisAlignment.,
              children: <Widget>[
                Text('Hello' ,style: TextStyle(fontSize: 40.0)),
                Padding(
                  padding: const EdgeInsets.only(left: 20, right: 20),
                  child: Text('World', style: TextStyle(fontSize: 40.0)),
                ),
                Text('John!', style: TextStyle(fontSize: 40.0))
              ],
            ),
            FlatButton(
              onPressed: (){
                debugPrint('clicou');
              },
              color: Colors.lightGreen,
              child: Text('Teste', style: TextStyle(fontSize: 20.0)),
            )
          ],
        ),
    ),);
  }
}
