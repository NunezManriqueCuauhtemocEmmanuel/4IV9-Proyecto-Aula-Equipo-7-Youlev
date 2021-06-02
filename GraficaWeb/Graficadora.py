
import webbrowser
import pandas as pd
import csv



data = pd.read_csv('nutricion.csv')

df = pd.DataFrame(data)


Cantidad = [ item for item in df['Deteccion Nutircion Delegaciones']]
Casos = [ item for item in df['2007']]
Casos2 = [ item for item in df['2019']]
#prueba


js = ""

a = 0

while a<35:
              js = js+"{x:'"+data['Deteccion Nutircion Delegaciones'].loc[a]+"', y:"+str(data['2007'].loc[a])+", z:"+str(a+1)+"},\n"
              a+=1


df.groupby('Deteccion Nutircion Delegaciones')['2007'].sum().plot(kind='line',title='Transacciones',color='blue')

i = 0
js1 = ""
while i<35:
              js1 = js1+"{x:'"+data['Deteccion Nutircion Delegaciones'].loc[i]+"', y:"+str(data['2019'].loc[i])+", z:"+str(i+1)+"},\n"
              i+=1
print (js1)

datos = pd.read_csv('total.csv')

df1 = pd.DataFrame(datos)
Casos9 = [ item for item in df1['Total']]

print(Casos9)




f = open('index.html','w')

mensaje = """<html>
              <head>
                            <title>Gráficas con JavaScript</title>
                            <meta charset='utf-8'>
                            <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>
                            <link rel='stylesheet' type='text/css' href='morris.css'>  
                            <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
                            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
                            <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
                            <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
                            <script src='Morris.js'></script>
                            <script>    
                            function grafica1(){
                                          new Morris.Line({
                                                        element: 'graph',
                                                        data: [""+script+""],
                                                        
                                                        xkey: 'x',
                                                        ykeys: ['y','z'],
                                                        axes:false,
                                                        labels: ['Y','Z'],
                                                        resize:true,
                                                        lineColors:['#2CB4AC']
                                          });
                            }
                            </script>
              </head>
                            <body>
                                                        
                            </body>
</html>

"""

f.write(mensaje)
f.close()