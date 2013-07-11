package com.kata.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class HanoiMoves {

	ArrayList<Peg> pegList;
	Stack<Disk> tempMove;

	public HanoiMoves() {
		pegList = new ArrayList<Peg>();
		tempMove = new Stack<Disk>();

	}

	public void init() {

	}

	public boolean moveDisk(Disk disk, Peg peg) {
		int s = disk.getSourcePeg();
		int t = disk.getTargetPeg();

		if (pegList.get(s).getFirst() == disk) {
			if (pegList.get(t).getFirst().getIndex() > disk.getIndex()) {
				pegList.get(t).add(pegList.get(s).remove());
				return true;
			}

			else {
				for (int i = 0; i < pegList.get(t).getSize() && pegList.get(); i++) {
					Disk diskTemp = pegList.get(t).remove();
					
//					tempMove.push(diskTemp);
				}
			}
		}

		return false;
	}

	private class Disk {
		int i;
		private int targetPeg, sourcePeg;

		public Disk(int i) {
			this.i = i;
		}

		public int getIndex() {
			return i;
		}

		public int getTargetPeg() {
			return targetPeg;
		}

		public void setTargetPeg(int targetPeg) {
			this.targetPeg = targetPeg;
		}

		public int getSourcePeg() {
			return sourcePeg;
		}

		public void setSourcePeg(int sourcePeg) {
			this.sourcePeg = sourcePeg;
		}

	}

	private class Peg {
		private int i;
		LinkedList<Disk> diskList;

		public Peg(int i) {
			this.i = i;
			diskList = new LinkedList<Disk>();
		}

		public boolean addLast(Disk i) {
			if (diskList.getLast().getIndex() < i.getIndex()) {
				diskList.add(i);
				return true;
			}

			else
				return false;

		}

		public boolean add(Disk i) {
			if (getFirst().getIndex() > i.getIndex()) {
				diskList.push(i);
				return true;
			}
			return false;
		}

		public Disk getFirst() {
			return diskList.getFirst();
		}

		public Disk remove() {
			return diskList.removeLast();
		}

		public int getSize() {
			return diskList.size();
		}

	}
}
