<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EzPay Transaction APIs</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="index.css">
<style>
body {
	background-color: #f4f7f6;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}

h1, h2 {
	color: #333;
	text-align: center;
}

.api-section {
	margin-bottom: 30px;
	align-content: center;
}

.api-section h2 {
	margin-bottom: 20px;
	font-size: 1.5rem;
	font-weight: 600;
}

.form-control {
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

.btn {
	background-color: #007BFF;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
	margin-right: 10px;
	text-align: center;
}

.btn:hover {
	background-color: #0056b3;
}

.reset-btn {
	background-color: #DC3545;
}

.reset-btn:hover {
	background-color: #c82333;
}

pre {
	background-color: #f1f1f1;
	padding: 15px;
	border-radius: 5px;
	white-space: pre-wrap;
	font-size: 0.9rem;
}
</style>
</head>
<body>
	<div class="container">
		<h1>EzPay Transaction APIs</h1>

		<!-- Test Controller 
		<div class="api-section">
			<h2>Test Controller</h2>
			<button class="btn btn-primary" onclick="testController()">Test</button>
			<button class="btn reset-btn" onclick="resetOutput('testResult')">Reset</button>
			<pre id="testResult"></pre>
		</div>
		-->

		<!-- Transactions by Date Range -->
		<div class="api-section">
			<h2>Transactions by Date Range</h2>
			<div class="form-row">
				<div class="col">
					<input type="datetime-local" id="startDate" class="form-control"
						placeholder="Start Date">
				</div>
				<div class="col">
					<input type="datetime-local" id="endDate" class="form-control"
						placeholder="End Date">
				</div>
			</div>
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByDateRange()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('dateRangeResult')">Reset</button>
			<pre id="dateRangeResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Exact Amount -->
		<div class="api-section">
			<h2>Transactions by Exact Amount</h2>
			<input type="number" id="exactAmount" class="form-control"
				placeholder="Exact Amount">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByExactAmount()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('exactAmountResult')">Reset</button>
			<pre id="exactAmountResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Minimum Amount -->
		<div class="api-section">
			<h2>Transactions by Minimum Amount</h2>
			<input type="number" id="minAmount" class="form-control"
				placeholder="Minimum Amount">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByMinAmount()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('minAmountResult')">Reset</button>
			<pre id="minAmountResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Maximum Amount -->
		<div class="api-section">
			<h2>Transactions by Maximum Amount</h2>
			<input type="number" id="maxAmount" class="form-control"
				placeholder="Maximum Amount">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByMaxAmount()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('maxAmountResult')">Reset</button>
			<pre id="maxAmountResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Type -->
		<div class="api-section">
			<h2>Transactions by Type</h2>
			<input type="text" id="transactionType" class="form-control"
				placeholder="Transaction Type">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByType()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('typeResult')">Reset</button>
			<pre id="typeResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Status -->
		<div class="api-section">
			<h2>Transactions by Status</h2>
			<input type="text" id="transactionStatus" class="form-control"
				placeholder="Transaction Status">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByStatus()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('statusResult')">Reset</button>
			<pre id="statusResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Mode -->
		<div class="api-section">
			<h2>Transactions by Mode</h2>
			<input type="text" id="transactionMode" class="form-control"
				placeholder="Transaction Mode">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByMode()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('modeResult')">Reset</button>
			<pre id="modeResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Description -->
		<div class="api-section">
			<h2>Transactions by Description</h2>
			<input type="text" id="descriptionKeyword" class="form-control"
				placeholder="Description Keyword">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByDescription()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('descriptionResult')">Reset</button>
			<pre id="descriptionResult" class="mt-3"></pre>
		</div>

		<!-- Transaction by Transaction ID -->
		<div class="api-section">
			<h2>Transaction by Transaction ID</h2>
			<input type="text" id="transactionId" class="form-control"
				placeholder="Transaction ID">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionByTransactionId()">Get Transaction</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('transactionIdResult')">Reset</button>
			<pre id="transactionIdResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Sender Account -->
		<div class="api-section">
			<h2>Transactions by Sender Account</h2>
			<input type="text" id="senderAccount" class="form-control"
				placeholder="Sender Account">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsBySenderAccount()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('senderAccountResult')">Reset</button>
			<pre id="senderAccountResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Receiver Account -->
		<div class="api-section">
			<h2>Transactions by Receiver Account</h2>
			<input type="text" id="receiverAccount" class="form-control"
				placeholder="Receiver Account">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByReceiverAccount()">Get
				Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('receiverAccountResult')">Reset</button>
			<pre id="receiverAccountResult" class="mt-3"></pre>
		</div>

		<!-- Transactions by Currency -->
		<div class="api-section">
			<h2>Transactions by Currency</h2>
			<input type="text" id="currency" class="form-control"
				placeholder="Currency">
			<button class="btn btn-primary mt-3"
				onclick="getTransactionsByCurrency()">Get Transactions</button>
			<button class="btn reset-btn mt-3"
				onclick="resetOutput('currencyResult')">Reset</button>
			<pre id="currencyResult" class="mt-3"></pre>
		</div>

		<!-- All Transactions -->
		<div class="api-section">
			<h2>All Transactions</h2>
			<button class="btn btn-primary" onclick="getAllTransactions()">Get
				All Transactions</button>
			<button class="btn reset-btn"
				onclick="resetOutput('allTransactionsResult')">Reset</button>
			<pre id="allTransactionsResult"></pre>
		</div>
	</div>

	<script src="index.js"></script>
	<script>
		function resetOutput(elementId) {
			document.getElementById(elementId).textContent = '';
		}
	</script>
</body>
</html>
