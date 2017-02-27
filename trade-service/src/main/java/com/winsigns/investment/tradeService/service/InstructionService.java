package com.winsigns.investment.tradeService.service;

import java.util.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winsigns.investment.tradeService.command.InstructionCommand;
import com.winsigns.investment.tradeService.model.Instruction;
import com.winsigns.investment.tradeService.repository.InstructionRepository;

@Service
public class InstructionService {

	@Autowired
	InstructionRepository instructionRepository;

	@Transactional
	public Instruction addInstruction(InstructionCommand instructionCommand) {

		Instruction newInstruction = new Instruction();

		newInstruction.setPortfolioId(instructionCommand.getPortfolioId());
		newInstruction.setSecurityId(instructionCommand.getSecurityId());
		newInstruction.setInvestSvc(instructionCommand.getInvestSvc());
		newInstruction.setInvestDirection(instructionCommand.getInvestDirection());
		newInstruction.setCurrency(Currency.getInstance(instructionCommand.getCurrency()));
		newInstruction.setCostPrice(instructionCommand.getCostPrice());
		newInstruction.setVolumeType(instructionCommand.getVolumeType());
		newInstruction.setQuantity(instructionCommand.getQuantity());
		newInstruction.setAmount(instructionCommand.getAmount());

		return instructionRepository.save(newInstruction);
	}

	@Transactional
	public Instruction updateInstruction(Long instructionId, InstructionCommand instructionCommand) {
		Instruction instruction = instructionRepository.findOne(instructionId);

		instruction.setPortfolioId(instructionCommand.getPortfolioId());
		instruction.setSecurityId(instructionCommand.getSecurityId());
		instruction.setInvestSvc(instructionCommand.getInvestSvc());
		instruction.setInvestDirection(instructionCommand.getInvestDirection());
		instruction.setCurrency(Currency.getInstance(instructionCommand.getCurrency()));
		instruction.setCostPrice(instructionCommand.getCostPrice());
		instruction.setVolumeType(instructionCommand.getVolumeType());
		instruction.setQuantity(instructionCommand.getQuantity());
		instruction.setAmount(instructionCommand.getAmount());

		return instructionRepository.save(instruction);
	}

	public void deleteInstruction(Long instructionId) {

		instructionRepository.delete(instructionId);
	}

	public Instruction findOne(Long instructionId) {
		return instructionRepository.findOne(instructionId);
	}

}
