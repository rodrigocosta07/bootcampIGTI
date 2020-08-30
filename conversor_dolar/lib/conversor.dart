import 'package:flutter/material.dart';

class Conversor extends StatefulWidget {
  @override
  _ConversorState createState() => _ConversorState();
}

class _ConversorState extends State<Conversor> {
  final TextEditingController _reaisController = TextEditingController();
  final TextEditingController _cotacaoDolarController = TextEditingController();
  var _resultado = '';

  _limpar() {
    _reaisController.clear();
    _cotacaoDolarController.clear();
    setState(() {
      _resultado = '';
    });
  }

  _calcular() {
    var reais = double.parse(_reaisController.text);
    var cotacao = double.parse(_cotacaoDolarController.text);
    var total = reais / cotacao;
    setState(() {
      _resultado =
          'Com $reais você é possivel comprar ${total.toStringAsFixed(2)} dolares a $cotacao cada';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          backgroundColor: Colors.indigo,
          title: Text('Reais para dolar'),
          centerTitle: true),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          TextField(
            controller: _reaisController,
            keyboardType: TextInputType.numberWithOptions(decimal: true),
            decoration: InputDecoration(
                hintText: 'Reais',
                border:
                    OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
                ),
          ),
          TextField(
            controller: _cotacaoDolarController,
            keyboardType: TextInputType.numberWithOptions(decimal: true),
            decoration: InputDecoration(
                hintText: 'Dolar',
                border:
                    OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
                ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              FlatButton(
                child: Text('Limpar',
                    style: TextStyle(fontSize: 20, color: Colors.white)),
                color: Colors.indigo,
                onPressed: _limpar,
              ),
              FlatButton(
                child: Text('Calcular',
                    style: TextStyle(fontSize: 20, color: Colors.white)),
                color: Colors.indigo,
                onPressed: _calcular,
              ),
            ],
          ),
          Text('$_resultado', style: TextStyle(fontSize: 30)),
        ],
      ),
    );
  }
}
