package id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.impl;

import id.my.hendisantika.taxesdemowebflux.domain.usecase.processmessage.IProcessMessageUseCase;
import lombok.RequiredArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : taxes-demo-webflux
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 09/08/25
 * Time: 13.39
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class ProcessMessageUseCase implements IProcessMessageUseCase {

    private final IMessageRepositoryPort messageRepositoryPort;
}
