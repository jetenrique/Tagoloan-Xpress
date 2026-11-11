const assetPathPrefix = "https://www.figma.com/api/mcp/asset/d618405d-0fc2-4732-a183-83c85ac03df7";
const imgPhoto = `${assetPathPrefix}/23657.png`;
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconCheck = `${assetPathPrefix}/c17fb.svg`;
const imgIconStar = `${assetPathPrefix}/6750a.svg`;

export default function CustomerRatingReceiptReview() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:3200" data-name="Customer Rating, Receipt & Review">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="127:342" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="127:343" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="127:344" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="127:345">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="127:346" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="127:347" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="127:349" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="127:351" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="127:353" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="127:354" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="127:355" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="127:357" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="127:358">
              Delivery complete
            </p>
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="127:359">
              #TGX-8921
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[8px] relative w-full" data-node-id="127:361" data-name="Body">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[6px] items-center overflow-clip px-[16px] py-[24px] relative rounded-[16px] shrink-0 w-full" data-node-id="127:362" data-name="Done">
            <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[28px] shrink-0 size-[56px]" data-node-id="127:363" data-name="Container">
              <div className="relative shrink-0 size-[28px]" data-node-id="127:364" data-name="icon/check">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
              </div>
            </div>
            <div className="h-[6px] relative shrink-0 w-px" data-node-id="127:366" data-name="Container" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[30px] text-center w-[min-content]" data-node-id="127:367">
              ₱255.00
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[13px] text-center w-[min-content]" data-node-id="127:368">
              Paid in cash · Thank you!
            </p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="127:369" data-name="Payment">
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="127:370" data-name="Row – Store receipt">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="127:371">
                Store receipt
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="127:372">
                ₱195.00
              </p>
            </div>
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[14px] w-full" data-node-id="127:373" data-name="Row – Delivery fee">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="127:374">
                Delivery fee
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="127:375">
                ₱60.00
              </p>
            </div>
            <div className="bg-[#ece8df] h-px relative shrink-0 w-full" data-node-id="127:376" data-name="Divider" />
            <div className="[word-break:break-word] content-stretch flex gap-[12px] items-center leading-[1.35] overflow-clip relative shrink-0 text-[#18181f] w-full" data-node-id="127:377" data-name="Row – Total paid">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold min-w-px relative text-[14px]" data-node-id="127:378">
                Total paid
              </p>
              <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[16px] whitespace-nowrap" data-node-id="127:379">
                ₱255.00
              </p>
            </div>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[14px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="127:380" data-name="Rate your rider">
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="127:381" data-name="Container">
              <div className="relative shrink-0 size-[40px]" data-node-id="127:382" data-name="Photo">
                <img alt="" className="absolute block inset-0 max-w-none size-full" height="40" src={imgPhoto} width="40" />
              </div>
              <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="127:383" data-name="Container">
                <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="127:384">
                  How was Juan?
                </p>
                <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="127:385">
                  Tap to rate your delivery
                </p>
              </div>
            </div>
            <div className="content-stretch flex gap-[10px] items-start justify-center overflow-clip relative shrink-0 w-full" data-node-id="127:386" data-name="Container">
              <div className="relative shrink-0 size-[32px]" data-node-id="127:387" data-name="icon/star">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
              </div>
              <div className="relative shrink-0 size-[32px]" data-node-id="127:389" data-name="icon/star">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
              </div>
              <div className="relative shrink-0 size-[32px]" data-node-id="127:391" data-name="icon/star">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
              </div>
              <div className="relative shrink-0 size-[32px]" data-node-id="127:393" data-name="icon/star">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
              </div>
              <div className="relative shrink-0 size-[32px]" data-node-id="127:395" data-name="icon/star">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconStar} />
              </div>
            </div>
            <div className="content-stretch flex gap-[8px] items-start justify-center overflow-clip relative shrink-0 w-full" data-node-id="127:397" data-name="Container">
              <div className="bg-[#fff7e0] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="127:398" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="127:399">
                  On time
                </p>
              </div>
              <div className="bg-[#fff7e0] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="127:400" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="127:401">
                  Polite
                </p>
              </div>
              <div className="bg-[#fff7e0] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="127:402" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="127:403">
                  Exact receipt
                </p>
              </div>
            </div>
            <div className="bg-[#fbf9f1] border border-[#ece8df] border-solid content-stretch flex h-[72px] items-start overflow-clip p-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="127:404" data-name="Comment">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="127:405">
                Fast and polite service!
              </p>
            </div>
          </div>
          <a className="bg-[#febc20] content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="127:406" data-name="Button – Submit & go home">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="127:407">{`Submit & go home`}</p>
          </a>
          <div className="[word-break:break-word] content-stretch flex gap-[4px] items-start justify-center leading-[1.35] overflow-clip relative shrink-0 text-[13px] w-full whitespace-nowrap" data-node-id="127:409" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73]" data-node-id="127:410">
              Problem with your receipt?
            </p>
            <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#6b4e00]" data-node-id="127:411">
              Get help
            </p>
          </div>
          <div className="h-[8px] relative shrink-0 w-px" data-node-id="127:412" data-name="Container" />
        </div>
      </div>
    </div>
  );
}
