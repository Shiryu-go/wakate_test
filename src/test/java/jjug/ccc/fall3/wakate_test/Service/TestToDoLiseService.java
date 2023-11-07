package jjug.ccc.fall3.wakate_test.Service;


import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TestToDoLiseService {
    @InjectMocks
    ToDoListService toDoListService;

    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderItemRepository orderItemRepository;
}
