!pip install nltk
import nltk
nltk.download('stopwords')
from nltk.corpus import stopwords
from sklearn.feature_extraction.text import TfidfVectorizer
import pandas as pd

def extract_keywords_tfidf(txt_path, num_keywords=10):
    # Leer el archivo de texto
    with open(txt_path, 'r', encoding='utf-8') as file:
        text = file.read()

    # Obtener la lista de stop words en español de NLTK
    spanish_stop_words = stopwords.words('spanish')

    # Crear el vectorizador TF-IDF
    # Usamos la lista de stop words en español
    vectorizer = TfidfVectorizer(stop_words=spanish_stop_words, max_features=6000)

    # Ajustar y transformar el texto
    tfidf_matrix = vectorizer.fit_transform([text])

    # Obtener los términos y sus puntajes TF-IDF
    feature_names = vectorizer.get_feature_names_out()
    tfidf_scores = tfidf_matrix.toarray()[0]

    # Crear un DataFrame con términos y sus puntajes
    tfidf_df = pd.DataFrame({'termino': feature_names, 'tfidf': tfidf_scores})

    # Ordenar por puntaje TF-IDF y seleccionar los términos principales
    top_keywords = tfidf_df.sort_values(by='tfidf', ascending=False).head(num_keywords)

    return top_keywords

# Extraer las palabras clave principales
top_keywords = extract_keywords_tfidf('expediente.txt')

# Mostrar los resultados
# The following line was replaced to use a standard pandas display method
print("Palabras Clave con TF-IDF:")
print(top_keywords.to_string())  # Display the DataFrame using to_string()
#print(top_keywords)
