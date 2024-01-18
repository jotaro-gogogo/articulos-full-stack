ready();

function ready() {
    function wrapper() {
        loadProducts();
        loadEvents();
    }
    if (document.readyState !== 'loading') {
        wrapper();
    } else
        document.addEventListener('DOMContentLoaded', wrapper);
}

function loadProducts() {
    fetch('http://localhost:9001/products/show')
    .then(response => {
        if (!response.ok) {
            console.log("error");
            throw new Error("Error");
        }
        return response.json();
    })
    .then(data => {
        const query = data.obj;
        let table = document.getElementById("table-products");

        for (let i = 0; i < query.length; i++) {
            let row = "";
            if (i%2 === 0)
                row = '<tr class="table-light">';
            else
                row = '<tr class="table-secondary">'
            table.innerHTML +=
                 row +
                    '<td> ' + query[i].id + '</td>' +
                    '<td>' + query[i].name + '</td>' +
                    '<td>' + query[i].unit + '</td>' +
                    '<td>' + query[i].productKey + '</td>' +
                    '<td>' + query[i].price + '</td>' +
                    '<td>' +
                        '<button class="btn btn-warning" type="button">Update</button>' +
                    '</td>' +
                    '<td>' +
                        '<button class="btn btn-danger" type="button">Delete</button>' +
                    '</td>' +
                '</tr>';
        }
    })
    .catch(error => {
        console.log("Another error");
    })
}

function loadEvents() {
    fetch('http://localhost:9001/events/show')
    .then(response => {
        if (!response.ok) {
            console.log("Error Fetching");
            throw new Error("Error fetching");
        }
        return response.json();
    })
    .then(data => {
        const query = data.obj;
        let table = document.getElementById("table-events");

        for(let i = 0; i < query.length; i++) {
            let dateVal = convertDate(query[i].txnDate);

            let row = "";
            if (i%2 === 0)
                row = '<tr class="table-light">';
            else
                row = '<tr class="table-secondary">'

            table.innerHTML +=
                row +
                    '<td>' + query[i].id + '</td>' +
                    '<td>' + query[i].txn + '</td>' +
                    '<td>' + dateVal + '</td>' +
                '</tr>';
        }
    })
    .catch(error => {
        console.log("Error");
    })
}

function convertDate(date) {
    date = date.replace(/T/, ' ');
    date = date.split('+');
    return date[0];
}




