import pandas as pd
import matplotlib.pyplot as plt

## csv designCodeSmells
# Agrupar por la columna 'Code Smell' y contar las ocurrencias
file_path = "designCodeSmells.csv"
df = pd.read_csv(file_path)
code_smell_count = df['Code Smell'].value_counts()
plt.figure(figsize=(10, 6))
code_smell_count.plot(kind='bar', color='skyblue')
plt.title("Frecuencia de Code Smell")
plt.xlabel("Tipo de Code Smell")
plt.ylabel("Frecuencia")
plt.show()  # Mostrar el gráfico

## csv implementationCodeSmells
# Agrupar por 'Code Smell' y contar ocurrencias
file_path = "implementationCodeSmells.csv"
df = pd.read_csv(file_path)
code_smell_count = df['Code Smell'].value_counts().sort_index()
plt.figure(figsize=(10, 6))
code_smell_count.plot(kind='area', color='skyblue', alpha=0.5)
plt.title("Distribución de Code Smells por Tipo")
plt.xlabel("Tipo de Code Smell")
plt.ylabel("Frecuencia")
plt.show()  # Mostrar el gráfico

## csv methodMetrics
# Crear un gráfico de dispersión para comparar LOC y CC
file_path = "methodMetrics.csv"
df = pd.read_csv(file_path)
plt.figure(figsize=(8, 6))
plt.scatter(df['LOC'], df['CC'], alpha=0.5, color='blue', edgecolors='w', s=100)
plt.title("Comparación entre LOC y CC")
plt.xlabel("Líneas de Código (LOC)")
plt.ylabel("Complejidad Ciclomática (CC)")
plt.grid(True)
plt.show()  

#csv typeMetrics
file_path = "typeMetrics.csv"
df = pd.read_csv(file_path)

# -Gráfico de dispersión para comparar NOPM y WMC
plt.figure(figsize=(8, 6))
plt.scatter(df['NOPM'], df['WMC'], alpha=0.5, color='red', edgecolors='w', s=100)
plt.title("Relación entre Métodos Públicos y Complejidad Ciclomática")
plt.xlabel("Número de Métodos Públicos (NOPM)")
plt.ylabel("Complejidad Ciclomática (WMC)")
plt.show()

# -Gráfico de barras para visualizar el número de hijos por clase (NC)
plt.figure(figsize=(8, 6))
df['NC'].value_counts().sort_index().plot(kind='bar', color='skyblue', alpha=0.7)
plt.title("Número de Hijos por Clase")
plt.xlabel("Número de Hijos (NC)")
plt.ylabel("Frecuencia")
plt.show()

# -Gráfico de dispersión para comparar DIT y LCOM
plt.figure(figsize=(8, 6))
plt.scatter(df['DIT'], df['LCOM'], alpha=0.5, color='green', edgecolors='w', s=100)
plt.title("Relación entre DIT y LCOM")
plt.xlabel("Profundidad del Árbol de Herencia (DIT)")
plt.ylabel("Falta de Cohesión de Métodos (LCOM)")
plt.show()

