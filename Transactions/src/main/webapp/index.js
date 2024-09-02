const baseUrl = "http://localhost:8087/Transactions/restapi/transactions";

function testController() {
    fetch(`${baseUrl}/test`)
        .then(response => response.json())
        .then(data => document.getElementById('testResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('testResult').textContent = error);
}

function getTransactionsByDateRange() {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    fetch(`${baseUrl}/dateRange?start=${startDate}&end=${endDate}`)
        .then(response => response.json())
        .then(data => document.getElementById('dateRangeResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('dateRangeResult').textContent = error);
}

function getTransactionsByExactAmount() {
    const amount = document.getElementById('exactAmount').value;
    fetch(`${baseUrl}/amount/exact?amount=${amount}`)
        .then(response => response.json())
        .then(data => document.getElementById('exactAmountResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('exactAmountResult').textContent = error);
}

function getTransactionsByMinAmount() {
    const minAmount = document.getElementById('minAmount').value;
    fetch(`${baseUrl}/amount/min?minAmount=${minAmount}`)
        .then(response => response.json())
        .then(data => document.getElementById('minAmountResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('minAmountResult').textContent = error);
}

function getTransactionsByMaxAmount() {
    const maxAmount = document.getElementById('maxAmount').value;
    fetch(`${baseUrl}/amount/max?maxAmount=${maxAmount}`)
        .then(response => response.json())
        .then(data => document.getElementById('maxAmountResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('maxAmountResult').textContent = error);
}

function getTransactionsByType() {
    const type = document.getElementById('transactionType').value;
    fetch(`${baseUrl}/type?type=${type}`)
        .then(response => response.json())
        .then(data => document.getElementById('typeResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('typeResult').textContent = error);
}

function getTransactionsByStatus() {
    const status = document.getElementById('transactionStatus').value;
    fetch(`${baseUrl}/status?status=${status}`)
        .then(response => response.json())
        .then(data => document.getElementById('statusResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('statusResult').textContent = error);
}

function getTransactionsByMode() {
    const mode = document.getElementById('transactionMode').value;
    fetch(`${baseUrl}/mode?mode=${mode}`)
        .then(response => response.json())
        .then(data => document.getElementById('modeResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('modeResult').textContent = error);
}

function getTransactionsByDescription() {
    const keyword = document.getElementById('descriptionKeyword').value;
    fetch(`${baseUrl}/description?keyword=${keyword}`)
        .then(response => response.json())
        .then(data => document.getElementById('descriptionResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('descriptionResult').textContent = error);
}

function getTransactionByTransactionId() {
    const transactionId = document.getElementById('transactionId').value;
    fetch(`${baseUrl}/${transactionId}`)
        .then(response => response.json())
        .then(data => document.getElementById('transactionIdResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('transactionIdResult').textContent = error);
}

function getTransactionsBySenderAccount() {
    const senderAccount = document.getElementById('senderAccount').value;
    fetch(`${baseUrl}/senderAccount?senderAccount=${senderAccount}`)
        .then(response => response.json())
        .then(data => document.getElementById('senderAccountResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('senderAccountResult').textContent = error);
}

function getTransactionsByReceiverAccount() {
    const receiverAccount = document.getElementById('receiverAccount').value;
    fetch(`${baseUrl}/receiverAccount?receiverAccount=${receiverAccount}`)
        .then(response => response.json())
        .then(data => document.getElementById('receiverAccountResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('receiverAccountResult').textContent = error);
}

function getTransactionsByCurrency() {
    const currency = document.getElementById('currency').value;
    fetch(`${baseUrl}/currency?currency=${currency}`)
        .then(response => response.json())
        .then(data => document.getElementById('currencyResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('currencyResult').textContent = error);
}

function getAllTransactions() {
    fetch(`${baseUrl}/all`)
        .then(response => response.json())
        .then(data => document.getElementById('allTransactionsResult').textContent = JSON.stringify(data, null, 2))
        .catch(error => document.getElementById('allTransactionsResult').textContent = error);
}
