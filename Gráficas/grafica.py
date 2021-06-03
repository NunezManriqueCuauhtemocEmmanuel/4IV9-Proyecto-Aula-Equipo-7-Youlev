# -*- coding: utf-8 -*-
"""
Created on Wed Jun  2 22:45:19 2021

@author: adrai
"""

import pandas as pd

import webbrowser


datos = pd.read_csv("csvGraficaIndividual.csv")

df = pd.DataFrame(datos)

delegacion = [item for item in df['Municipio o delegación']]
casos = [item for item in df['Porcentaje de población de 20 años y más con diagnóstico previo de diabetes.']]
df = df[df["Clave de municipio o delegación"] == 0]
df = df[df["Estimador"] == "Valor"]
arreglo = df.index

script = ""

i=0

while i<32:

        script = script+"{x:'"+df['Entidad federativa'].loc[arreglo[i]]+"', y:"+str(df['Porcentaje de población de 20 años y más con diagnóstico previo de diabetes.'].loc[arreglo[i]])+", z:"+str(i+1)+"},\n"

        i+=1

print (script)



df.groupby('Entidad federativa')['Porcentaje de población de 20 años y más con diagnóstico previo de diabetes.'].sum().plot(kind='bar',legend='Reverse')



f = open('grafica.html','w')



mensaje = """<html>

<head>

<title>Gráficas con JavaScript</title>

<meta charset='utf-8'>

<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>

<link rel='stylesheet' type='text/css' href='morris.css'>  

<link rel="stylesheet" href="style.css">

<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js'></script>

<script src='http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js'></script>

<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script> 

<script src='morris.min.js'></script>

<script>    

function grafica1(){

  new Morris.Bar({

  element: 'graph',

  data: ["""+script+"""

          ],
  barColors: function (row, series, type) {
        switch(row.y){
        case 1: {
            return 'red';
        }
        default:{
            return 'green';
        } 
    }
  },
  xkey: 'x',

  ykeys: ['y'],

  axes:false,

  labels: ['Cantidad:'],

  resize:true,

  lineColors:['#2CB4AC']

  });

}

</script>

</head>

<body>

<div id='graph'></div>

<input class='buttons' type='button' value='Grafica' onclick='grafica1()'>

</body>

</html>"""

f.write(mensaje)

f.close()



webbrowser.open_new_tab('grafica.html')
