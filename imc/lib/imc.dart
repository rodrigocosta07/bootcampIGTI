import 'package:flutter/material.dart';

class Imc extends StatefulWidget {
  @override
  _ImcState createState() => _ImcState();
}

class _ImcState extends State<Imc> {
  final TextEditingController _alturaController = TextEditingController();
  final TextEditingController _pesoController = TextEditingController();
  final key =  GlobalKey<ScaffoldState>();
  var _resultado =  '';
  _onItemTapped(int index){
    if(index == 0){
      _pesoController.clear();
      _alturaController.clear();
      setState(() {
        _resultado = '';
      });
    } else if(_pesoController.text.isEmpty || _alturaController.text.isEmpty){
      key.currentState.showSnackBar(SnackBar(
        content: Text('Altura e peso são obrigatorios'),
      ));
    } else {
      try{
        var peso = double.parse(_pesoController.text);
        var altura = double.parse(_alturaController.text);
        var imc = peso / (altura * altura);
        setState(() {
          _resultado = 'Seu IMC é  ${imc.toStringAsFixed(2)}';
        });
      }catch(e){
        key.currentState.showSnackBar(SnackBar(
          content: Text('Altura ou peso foram informados em formato inválido.'),
        ));
      }

    }
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: key,
      appBar: AppBar(
        backgroundColor: Colors.indigo,
        title: Text('Calculo do IMC'),
        centerTitle: true
      ),
      body: Column(
        children: <Widget>[
          TextField(
            controller: _alturaController,
            keyboardType: TextInputType.numberWithOptions(decimal: true),
            decoration: InputDecoration(
              hintText: 'Altura',
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(10)
              ),
              icon: Icon(Icons.accessibility)
            ),
          ),
          TextField(
            controller: _pesoController,
            keyboardType: TextInputType.numberWithOptions(decimal: true),
            decoration: InputDecoration(
                hintText: 'Altura',
                border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10)
                ),
                icon: Icon(Icons.person)
            ),
          ),
          Text('$_resultado', style: TextStyle(fontSize: 30)),
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: Colors.indigo,
        onTap: _onItemTapped,
        items: [
          BottomNavigationBarItem(
            backgroundColor: Colors.white,
            icon: Icon(Icons.clear),
            title: Text('Limpar')
          ),
          BottomNavigationBarItem(
              backgroundColor: Colors.white,
            icon: Icon(Icons.check),
              title: Text('Calcular')
          )
        ]
      ),
    );
  }
}
