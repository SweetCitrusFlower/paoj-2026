package com.pao.laboratory07.exercise1;

import com.pao.laboratory07.exercise1.exceptions.CannotCancelFinalOrderException;
import com.pao.laboratory07.exercise1.exceptions.CannotRevertInitialOrderStateException;
import com.pao.laboratory07.exercise1.exceptions.OrderIsAlreadyFinalException;
import java.util.Stack;

public class Order {
    private OrderState orderState;
    private final Stack<OrderState> orderOrderStackOrderTrace;

    public Order(OrderState orderState){
        this.orderState = orderState;

        this.orderOrderStackOrderTrace = new Stack<>();
        orderOrderStackOrderTrace.push(orderState);
    }

    public OrderState getOrderState(){return this.orderState;}
    
    public void nextState(){
        switch(this.orderState){
            case PLACED -> {
                this.orderState = OrderState.PROCESSED;
                orderOrderStackOrderTrace.push(orderState);
                
                System.out.println("Order state updated to: " + this.orderState.name());
            }
            case PROCESSED -> {
                this.orderState = OrderState.SHIPPED;
                orderOrderStackOrderTrace.push(orderState);
                
                System.out.println("Order state updated to: " + this.orderState.name());
            }
            case SHIPPED -> {
                this.orderState = OrderState.DELIVERED;
                orderOrderStackOrderTrace.push(orderState);

                System.out.println("Order state updated to: " + this.orderState.name());
            }
            case DELIVERED -> {
                throw new OrderIsAlreadyFinalException(); 
            }
            case CANCELLED -> {
                throw new OrderIsAlreadyFinalException();
            }
        }
    };

    public void cancel(){
        switch(this.orderState){
            case PLACED -> {
                this.orderState = OrderState.CANCELLED;
                orderOrderStackOrderTrace.push(orderState);
                
                System.out.println("Order has been canceled.");
            }
            case PROCESSED -> {
                this.orderState = OrderState.CANCELLED;
                orderOrderStackOrderTrace.push(orderState);
                
                System.out.println("Order has been canceled.");
            }
            case SHIPPED -> {
                this.orderState = OrderState.CANCELLED;
                orderOrderStackOrderTrace.push(orderState);
                
                System.out.println("Order has been canceled.");
            }
            case DELIVERED -> {
                throw new CannotCancelFinalOrderException();
            }
            case CANCELLED -> {
                throw new CannotCancelFinalOrderException(); 
            }
        }
    };
    
    public void undoState(){
        if(this.orderOrderStackOrderTrace.size() <= 1){
            throw new CannotRevertInitialOrderStateException();
        }

        this.orderOrderStackOrderTrace.pop();
        this.orderState = this.orderOrderStackOrderTrace.peek();
        
        System.out.println("Order state reverted to: " + this.orderState.name());
    }
}
