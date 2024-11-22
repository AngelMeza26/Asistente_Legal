!pip install pymupdf
from google.colab import files
import fitz  # PyMuPDF
import os

def pdf_to_txt_lowercase(pdf_path, txt_path):
  """Convierte un PDF a texto en minúsculas y lo guarda en un archivo .txt."""
  pdf_document = fitz.open(pdf_path)
  text = ""
  for page_num in range(pdf_document.page_count):
      page = pdf_document[page_num]
      text += page.get_text() + "\n"
  pdf_document.close()
  with open(txt_path, 'w', encoding='utf-8') as txt_file:
      txt_file.write(text.lower())

# Subir el archivo PDF
uploaded = files.upload()

# Obtener el nombre del archivo subido
pdf_filename = list(uploaded.keys())[0]

# Convertir el PDF a texto en minúsculas
pdf_to_txt_lowercase(pdf_filename, 'expediente.txt')

print(f"El archivo '{pdf_filename}' se ha convertido a 'expediente.txt' en minúsculas.")

files.download('expediente.txt')
