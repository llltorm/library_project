package net.project.library.service;

import net.project.library.model.Reader;
import net.project.library.repository.ReaderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderService readerService;


    @Test
    public void testFindAllReaders() {
        Reader reader = new Reader();
        Mockito.when(readerRepository.findAll()).thenReturn(List.of(reader));
        List<Reader> result = readerService.findALL();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testCreateReader() {
        Reader reader = new Reader("reader");
        when(readerService.saveReader(reader)).thenReturn(reader);
        Reader result = readerService.saveReader(reader);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("reader", result.getName());
        verify(readerRepository).save(reader);
    }

    @Test
    public void testFindReaderById() {
        Reader reader = new Reader();
        reader.setId(100);
        when(readerRepository.findById(100)).thenReturn(Optional.of(reader));
        Optional returnedReader = readerRepository.findById(100);
        Reader newReturnedReader = (Reader) returnedReader.get();
        assertEquals(reader.getId(), newReturnedReader.getId());
        verify(this.readerRepository).findById(100);
    }

    @Test
    void deleteReader() {
        readerService.deleteById(1);
        verify(readerRepository).deleteById(1);
    }
}
