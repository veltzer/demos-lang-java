package calculator.client;

public abstract class CalculatorClient {
	public static void main(String[] args) {
		StatefulCalculatorService service = new StatefulCalculatorService();
		StatefulCalculator port = service.getStatefulCalculatorPort();

		((BindingProvider) port).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

		port.startCalc(11);

		float result = port.invokeOperation(Operation.ADD, 3);
		System.out.println(result);

		result = port.invokeOperation(Operation.MUL, 4);
		System.out.println(result);

		result = port.invokeOperation(Operation.DIV, 1.5F);
		System.out.println(result);
	}

}
