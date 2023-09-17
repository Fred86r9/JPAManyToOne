const urlKommune ="https://api.dataforsyningen.dk/kommuner";

function fetchKommuner(any)
{
    return fetch(any).then(response => response.json());
}

function actionFetch()
{
    const kommuner = fetchKommuner(urlKommune);
    console.log(kommuner)
}