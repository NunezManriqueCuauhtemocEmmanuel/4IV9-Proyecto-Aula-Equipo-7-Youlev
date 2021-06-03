# -*- coding: utf-8 -*-
"""
Created on Mon May 31 15:52:54 2021

@author: Emiliano
"""


import pandas as pd

import webbrowser

datos = pd.read_csv("csvGraficaIndividualUTF.csv")

df = pd.DataFrame(datos)

df = df[df["Identificador único del municipio"] >= 9001]
df = df[df["Identificador único del municipio"] <= 9100]
df = df[df["Clave de municipio o delegación"] >= 1]
df = df[df["Estimador"] == 'Valor']

print(df['Municipio o delegación'].loc[1425])

indexData = df.index

script = ""

i=0

while i<16:

        script = script+"{x:'"+df['Municipio o delegación'].loc[indexData[i]]+"', y:"+str(df['Porcentaje de población de 20 años y más con obesidad.'].loc[indexData[i]])+", z:"+str(i+1)+"},\n"

        i+=1

print (script)

#df.groupby('Municipio o delegación')['Porcentaje de población de 20 años y más con obesidad.'].sum().plot(kind='line',legend='Reverse',title='Transacciones',color='gray')

#df.groupby('Municipio o delegación')['Porcentaje de población de 20 años y más con obesidad.'].sum().plot(kind='bar',legend='Reverse')

df.groupby('Municipio o delegación')['Porcentaje de población de 20 años y más con obesidad.'].sum().plot(kind='barh',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='hist',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='box',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='kde',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='density',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='area',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='pie',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='scatter',legend='Reverse')

#df1.groupby('Name')['Transaction'].sum().plot(kind='hexbin',legend='Reverse')

f = open('grafica.html','w')



mensaje = """<html>

<head>

<title>Gráficas con JavaScript</title>

<meta charset='utf-8'>

<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>

<link rel='stylesheet' type='text/css' href='morris.css'>
<link rel='stylesheet' type='text/css' href='styleGraph.css'>  

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

  xkey: 'x',

  ykeys: ['y'],

  axes:true,

  labels: ['Porcentaje (%)'],

  resize:true,
  
  barColors: ['#8FC3AC'],
  
  hideHover: 'auto',

  lineColors:['#8FC2C3']

  });

}

</script>

</head>

<body>

<p id='titulo'>Porcentajes de Poblacion Mayor a 20 años con Obesidad en la Ciudad de México</p>

<div id='container'>

    <div id='graph'></div>
    
    <input type='button' id='boton' value='Generar Grafica' onclick='grafica1()'>

</div>

</body>

</html>"""

f.write(mensaje)

f.close()



webbrowser.open_new_tab('grafica.html')



#print(datos.to_excel("CreditCards.xls",sheet_name="datos"))