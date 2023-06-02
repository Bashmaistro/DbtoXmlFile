fetch('veriler.json')
  .then(response => response.json())
  .then(data => {
    createTable(data); // Tabloyu oluşturan fonksiyonu çağırın
  })
  .catch(error => console.error('Hata:', error));

function createTable(data) {
  // Tablo oluşturma işlemleri
  var table = document.createElement('table');
  // Tablonun içeriğini ayarlayın (örneğin, thead, tbody, satırlar vs.)

  // Tabloyu HTML sayfasına ekleyin
  var tableContainer = document.getElementById('table-container');
  tableContainer.appendChild(table);
}
