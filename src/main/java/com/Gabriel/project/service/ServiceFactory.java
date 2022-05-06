package com.Gabriel.project.service;

import com.Gabriel.project.repository.BookRepository;
import com.Gabriel.project.repository.BorrowRepository;
import com.Gabriel.project.repository.CategoryRepository;
import com.Gabriel.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Service factory.
 */
@Service
public class ServiceFactory {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Create service basic service.
     *
     * @param serviceType the service type
     * @return the basic service
     */
    public BasicService createService(ServiceType serviceType)
    {

        if(serviceType.equals(ServiceType.BOOK)) {
            return new BookService(bookRepository);
        }
        if(serviceType.equals(ServiceType.CATEGORY)){
            return new CategoryService(categoryRepository);
        }
        if(serviceType.equals(ServiceType.BORROW)){
            return new BorrowService(borrowRepository, bookRepository);
        }
        if(serviceType.equals(ServiceType.CLIENT)){
            return new ClientService(clientRepository);
        }

        return null;

    }
}
