package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.contract.AccountPayload;

public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Integer> implements AccountService{
}
