# Cálculo de Spam en el Servidor de Correo

Programa en Java para que el administrador de infraestructura de la
empresa ACME pueda conocer el índice promedio de spam en su servidor
de correo.

## ¿Qué hace?

1. Pide al usuario el nombre del archivo a analizar (`mbox.txt`,
   `mbox-short.txt`, etc.).
2. Recorre el archivo línea por línea buscando el parámetro
   `X-DSPAM-Confidence` en cada correo.
3. Calcula el **promedio** de todos esos valores y lo muestra por
   consola.
4. Genera un archivo de salida `spam_remitente.txt` con los
   remitentes cuyos mensajes tienen un puntaje de spam mayor a **0.7**
   (posibles spam).

## Ejemplo de ejecución

```
Enter the file name: mbox.txt
Average spam confidence: 0.894128046745
```