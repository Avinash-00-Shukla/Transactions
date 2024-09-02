package EzPay.Transactions.Controller;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionMode;
import EzPay.Transactions.Model.TransactionStatus;
import EzPay.Transactions.Model.TransactionType;
import EzPay.Transactions.Service.TransactionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/transactions")
public class TransactionController {
	 
	private TransactionService transactionService = new TransactionService();;

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String testingController() {
		return "Passed";
	}

	@GET
	@Path("/dateRange")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByDateRange(@QueryParam("start") String startDate,
			@QueryParam("end") String endDate) {
		try {
			LocalDateTime start = LocalDateTime.parse(startDate);
			LocalDateTime end = LocalDateTime.parse(endDate);
			List<Transaction> transactions = transactionService.getTransactionsByDateRange(start, end);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/amount/exact")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByExactAmount(@QueryParam("amount") double amount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByExactAmount(amount);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/amount/min")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByMinAmount(@QueryParam("minAmount") double minAmount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByMinAmount(minAmount);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/amount/max")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByMaxAmount(@QueryParam("maxAmount") double maxAmount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByMaxAmount(maxAmount);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/type")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByType(@QueryParam("type") String type) {
		try {
			TransactionType transactionType = TransactionType.valueOf(type);
			List<Transaction> transactions = transactionService.getTransactionsByType(transactionType);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByStatus(@QueryParam("status") String status) {
		try {
			TransactionStatus transactionStatus = TransactionStatus.valueOf(status);
			List<Transaction> transactions = transactionService.getTransactionsByStatus(transactionStatus);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mode")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByMode(@QueryParam("mode") String mode) {
		try {
			TransactionMode transactionMode = TransactionMode.valueOf(mode);
			List<Transaction> transactions = transactionService.getTransactionsByMode(transactionMode);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/description")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByDescription(@QueryParam("keyword") String descriptionKeyword) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByDescription(descriptionKeyword);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/{transactionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionByTransactionId(@PathParam("transactionId") String transactionId) {
		try {
			List<Transaction> transactions = transactionService.getTransactionByTransactionId(transactionId);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/senderAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsBySenderAccount(@QueryParam("senderAccount") String senderAccount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsBySenderAccount(senderAccount);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/receiverAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByReceiverAccount(@QueryParam("receiverAccount") String receiverAccount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByReceiverAccount(receiverAccount);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/currency")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByCurrency(@QueryParam("currency") String currency) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsByCurrency(currency);
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTransactions() {
		try {
			List<Transaction> transactions = transactionService.getAllTransactions();
			return Response.ok(transactions).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
}
