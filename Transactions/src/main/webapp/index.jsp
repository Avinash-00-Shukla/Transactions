<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EzPay Transaction APIs</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="container">
        <h1>EzPay Transaction APIs</h1>

        <div class="api-section">
            <h2>Test Controller</h2>
            <button onclick="testController()">Test</button>
            <pre id="testResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Date Range</h2>
            <input type="text" id="startDate" placeholder="Start Date (YYYY-MM-DDTHH:MM:SS)">
            <input type="text" id="endDate" placeholder="End Date (YYYY-MM-DDTHH:MM:SS)">
            <button onclick="getTransactionsByDateRange()">Get Transactions</button>
            <pre id="dateRangeResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Exact Amount</h2>
            <input type="number" id="exactAmount" placeholder="Exact Amount">
            <button onclick="getTransactionsByExactAmount()">Get Transactions</button>
            <pre id="exactAmountResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Minimum Amount</h2>
            <input type="number" id="minAmount" placeholder="Minimum Amount">
            <button onclick="getTransactionsByMinAmount()">Get Transactions</button>
            <pre id="minAmountResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Maximum Amount</h2>
            <input type="number" id="maxAmount" placeholder="Maximum Amount">
            <button onclick="getTransactionsByMaxAmount()">Get Transactions</button>
            <pre id="maxAmountResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Type</h2>
            <input type="text" id="transactionType" placeholder="Transaction Type">
            <button onclick="getTransactionsByType()">Get Transactions</button>
            <pre id="typeResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Status</h2>
            <input type="text" id="transactionStatus" placeholder="Transaction Status">
            <button onclick="getTransactionsByStatus()">Get Transactions</button>
            <pre id="statusResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Mode</h2>
            <input type="text" id="transactionMode" placeholder="Transaction Mode">
            <button onclick="getTransactionsByMode()">Get Transactions</button>
            <pre id="modeResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Description</h2>
            <input type="text" id="descriptionKeyword" placeholder="Description Keyword">
            <button onclick="getTransactionsByDescription()">Get Transactions</button>
            <pre id="descriptionResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transaction by Transaction ID</h2>
            <input type="text" id="transactionId" placeholder="Transaction ID">
            <button onclick="getTransactionByTransactionId()">Get Transaction</button>
            <pre id="transactionIdResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Sender Account</h2>
            <input type="text" id="senderAccount" placeholder="Sender Account">
            <button onclick="getTransactionsBySenderAccount()">Get Transactions</button>
            <pre id="senderAccountResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Receiver Account</h2>
            <input type="text" id="receiverAccount" placeholder="Receiver Account">
            <button onclick="getTransactionsByReceiverAccount()">Get Transactions</button>
            <pre id="receiverAccountResult"></pre>
        </div>

        <div class="api-section">
            <h2>Transactions by Currency</h2>
            <input type="text" id="currency" placeholder="Currency">
            <button onclick="getTransactionsByCurrency()">Get Transactions</button>
            <pre id="currencyResult"></pre>
        </div>

        <div class="api-section">
            <h2>All Transactions</h2>
            <button onclick="getAllTransactions()">Get All Transactions</button>
            <pre id="allTransactionsResult"></pre>
        </div>
    </div>

    <script src="index.js"></script>
</body>
</html>
