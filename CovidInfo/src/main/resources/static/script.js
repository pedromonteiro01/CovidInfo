const toggleButton = document.getElementsByClassName('toggle-button')[0]
const navbarLinks = document.getElementsByClassName('navbar-links')[0]

toggleButton.addEventListener('click', () => {
  navbarLinks.classList.toggle('active')
})

let data;
const URLAPI = "http://localhost:8080/api/v1/countries";
function setData(dt) {
    data = dt;
}
fetch(URLAPI)
      .then(response => response.json()).then( json => setData(json))
      .catch(error => console.error(error))
      .finally(() => {
        var selectElement = document.getElementById('ageselect');
        var stringifiedData = JSON.stringify(data);
        var parsedData = JSON.parse(stringifiedData);
        const length = Object.keys(parsedData).length;

        for (var i = 0; i < length; ++i) {
          selectElement[selectElement.length] = new Option(parsedData[i], parsedData[i]);
        }

});

function getData() {
  let data;
  var selectElement = document.getElementById('ageselect');
  var country = selectElement.value;
  const URLAPI = "http://localhost:8080/api/v1/countries/"+country;
  function setData(dt) {
      data = dt;
  }
        
  fetch(URLAPI)
        .then(response => response.json()).then( json => setData(json))
        .catch(error => console.error(error))
        .finally(() => {
          document.getElementById("covid-data").style.display = "block";
          var selectElement = document.getElementById('ageselect');
          var country = selectElement.value;
          var newCases = document.getElementById('new-cases');
          var activeCases = document.getElementById('active-cases');
          var recoveredCases = document.getElementById('recovered-cases');
          var totalCases = document.getElementById('total-cases');
          var deaths = document.getElementById('deaths');
          var totalDeaths = document.getElementById('total-deaths');
          var tests = document.getElementById('tests');
          var stringifiedData = JSON.stringify(data);
          var parsedData = JSON.parse(stringifiedData);
          const length = Object.keys(parsedData).length;
  
          for (var i = 0; i < length; ++i) {
            var c1 = JSON.stringify(parsedData[i]);
            c2 = JSON.parse(c1);
            newCases.innerHTML = c2.newCases.toString();
            activeCases.innerHTML = c2.activeCases;
            recoveredCases.innerHTML = c2.recoveredCases;
            totalCases.innerHTML = c2.totalCases;
            deaths.innerHTML = c2.newDeaths;
            totalDeaths.innerHTML = c2.totalDeaths;
            tests.innerHTML = c2.totalTests;
          }
  });
}

function getData2() {
  let data;
  var textBox = document.getElementById('country-box');
  var country = textBox.value;
  const URLAPI = "http://localhost:8080/api/v1/countries/"+country;
  function setData(dt) {
      data = dt;
  }
        
  fetch(URLAPI)
        .then(response => response.json()).then( json => setData(json))
        .catch(error => console.error(error))
        .finally(() => {
          var newCases = document.getElementById('new-cases2');
          var activeCases = document.getElementById('active-cases2');
          var recoveredCases = document.getElementById('recovered-cases2');
          var totalCases = document.getElementById('total-cases2');
          var deaths = document.getElementById('deaths2');
          var totalDeaths = document.getElementById('total-deaths2');
          var tests = document.getElementById('tests2');
          console.log(data);
          if (data.name === "Not Available") {
            document.getElementById("covid-data2").style.display = "none";
            document.getElementById("country-fail").style.display = "block";
          }
          else {
            document.getElementById("covid-data2").style.display = "block";
            document.getElementById("country-fail").style.display = "none";
          }
          newCases.innerHTML = data.newCases;
          activeCases.innerHTML = data.activeCases;
          recoveredCases.innerHTML = data.recoveredCases;
          totalCases.innerHTML = data.totalCases;
          deaths.innerHTML = data.newDeaths;
          totalDeaths.innerHTML = data.totalDeaths;
          tests.innerHTML = data.totalTests;
  });
}

function getCache() {
  let data;
  var selectElement = document.getElementById('ageselect');
  var country = selectElement.value;
  const URLAPI = "http://localhost:8080/api/v1/cache";
  function setData(dt) {
      data = dt;
  }
        
  fetch(URLAPI)
        .then(response => response.json()).then( json => setData(json))
        .catch(error => console.error(error))
        .finally(() => {
          var hits = document.getElementById('hits');
          var misses = document.getElementById('misses');
          var requests = document.getElementById('requests');
          console.log(data);
          hits.innerHTML = data.hits;
          misses.innerHTML = data.misses;
          requests.innerHTML = data.requests;
  });
}

document.getElementById("btn-search").addEventListener('click', getData);
document.getElementById("btn-text-search").addEventListener('click', getData2);
document.getElementById("cache-update").addEventListener('click', getCache);
